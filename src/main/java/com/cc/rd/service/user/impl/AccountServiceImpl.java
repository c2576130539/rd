package com.cc.rd.service.user.impl;

import com.cc.rd.config.SmsConfig;
import com.cc.rd.dao.UserMapper;
import com.cc.rd.dto.UserDto;
import com.cc.rd.entity.User;
import com.cc.rd.enums.Constant;
import com.cc.rd.enums.ErrorCodeEnum;
import com.cc.rd.enums.GenderEnum;
import com.cc.rd.exception.ManagerException;
import com.cc.rd.request.user.*;
import com.cc.rd.service.catpcha.CaptchaService;
import com.cc.rd.service.user.AccountService;
import com.cc.rd.service.user.LogOutService;
import com.cc.rd.service.user.UserService;
import com.cc.rd.util.DateTimeUtils;
import com.cc.rd.util.JwtUtils;
import com.cc.rd.util.RandomUtils;
import com.cc.rd.validator.BizValidator;
import com.cc.rd.validator.FastValidator;
import com.cc.rd.vo.user.UserLoginVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @program: AccountServiceImpl
 * @description: 账号逻辑实现
 * @author: cchen
 * @create: 2019-03-06 21:49
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private BizValidator bizValidator;

    @Autowired
    private LogOutService logOutService;

    /*
     *验证验手机证码是否正确
     */
    @Override
    public void isRightCode(TelphoneCodeRequest telphoneCodeRequest) {
        String telphone = telphoneCodeRequest.getTelphone();
        String code = telphoneCodeRequest.getCode();
        FastValidator.start().regTelphone(telphone)
                .notNull(code, "code");
        String cacheKey = getCacheKey(telphone, "code");
        String smsCode = (String) redisTemplate.opsForValue().get(cacheKey);
        if (!code.toLowerCase().equals(smsCode)) {
            throw new ManagerException(ErrorCodeEnum.TELPHONE_CODE_ERROR);
        }
    }

    @Override
    public void newUserCode(String telphone) {
        //用户不存在
        bizValidator.isExistUser(null, telphone, null);
        //发送短信注册码
        sendTelCode(telphone);
    }

    @Override
    public void oldUserCode(String telphone) {
        //用户存在
        isExistUser(null, telphone, null);
        //发送短信注册码
        sendTelCode(telphone);
    }

    @Override
    public void registerUser(UserAddRequest userAddRequest) {
        FastValidator.start().on(userAddRequest.getPassword(), 8, 16);
        //账号不存在
        bizValidator.isExistUser(null, userAddRequest.getTelphone(), null);
        //手机验证码是否一致
        TelphoneCodeRequest telphoneCodeRequest = new TelphoneCodeRequest(userAddRequest.getTelphone(), userAddRequest.getCode());
        isRightCode(telphoneCodeRequest);
        //两次密码是否一致
        isRightPassword(userAddRequest.getPassword(), userAddRequest.getConfirmPassword());

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userAddRequest, userDto);
        userService.addUser(userDto);
    }

    @Override
    public UserLoginVo login(UserLoginRequest userLoginRequest) {
        FastValidator.start().regTelphone(userLoginRequest.getTelphone())
                .notNull(userLoginRequest.getPassword());
        //验证错误次数，5分钟内超过五次则锁定一天
        String telphone = userLoginRequest.getTelphone();
        String cacheKey = getCacheKey(telphone, Constant.ERROR_NUM);
        String errNum = (String) redisTemplate.opsForValue().get(cacheKey);
        Integer num = 0;
        if (!StringUtils.isEmpty(errNum)) {
            num = Integer.valueOf(errNum);
        }
        if (num >= Constant.PASSWORD_ERROR_NUMBER) {
            throw new ManagerException(ErrorCodeEnum.USER_LOCK);
        }
        //图片验证码
        String code = userLoginRequest.getCode();
        //验证码防爆破
        if (!StringUtils.isEmpty(code)) {
            Object mark = redisTemplate.opsForValue().get(getCacheKey(telphone, code));
            if (null != mark) {
                throw new ManagerException(ErrorCodeEnum.CAPTCHA_FREASH);
            }
            //相同用户相同验证码打标，2分钟内防重放
            try {
                redisTemplate.opsForValue().set(getCacheKey(telphone, code), ""+ DateTimeUtils.utcNow(), 2, TimeUnit.MINUTES);
            } catch (Exception e) {
                //放行
                logger.error("验证码打标异常, telphone={}", telphone, e);
            }
        }
        //校验图片验证码
        if (num > 0 || !StringUtils.isEmpty(code)) {
            captchaService.checkCode(userLoginRequest.getToken(), code);
        }
        //账号是否存在
        User user = isExistUser(null, telphone, null);
        //校验密码是否一致
        if (!user.getPassword().equals(userLoginRequest.getPassword().toLowerCase())) {
            //记录错误次数
            num++;
            //五分钟内错误五次，锁定账号一天
            if (num == Constant.PASSWORD_ERROR_NUMBER) {
                redisTemplate.opsForValue().set(getCacheKey(telphone, Constant.ERROR_NUM), num.toString());
                redisTemplate.expire(getCacheKey(telphone, Constant.ERROR_NUM), Constant.DAYS, TimeUnit.HOURS);
            } else {
                redisTemplate.opsForValue().set(getCacheKey(telphone, Constant.ERROR_NUM), num.toString());
                redisTemplate.expire(getCacheKey(telphone, Constant.ERROR_NUM), Constant.PASSWORD_ERROR_NUMBER, TimeUnit.MINUTES);
            }
            throw new ManagerException(ErrorCodeEnum.USER_PASSWORD_ERROR);
        }

        Map<String, Object> map = new HashMap<>(1);
        map.put("userId", user.getId().toString());
        map.put("telphone", user.getTelphone());
        String token = "";
        try {
            token = JwtUtils.getToken(map);
            UserLoginVo userLoginVo = new UserLoginVo();
            userLoginVo.setToken(token);
            userLoginVo.setTelphone(telphone);
            userLoginVo.setNickName(StringUtils.isEmpty(user.getNickName())? Constant.USER_NAME:user.getNickName());
            userLoginVo.setGender(GenderEnum.findByCode(user.getGender()).geteDesc());
            userLoginVo.setMoney(user.getMoney());
            userLoginVo.setCredit(user.getCredit());
            userLoginVo.setUserImage(user.getUserImage());

            logOutService.clearLogoutStatus(user.getId().toString());
            return userLoginVo;
        } catch (Exception e) {
            logger.error("jwt get token failed, request={}", userLoginRequest, e);
            throw new ManagerException(ErrorCodeEnum.TOKEN_CREATE_FAILED);
        }
    }

    @Override
    public void updatePassword(UpdatePasswordRequest updatePasswordRequest, Long userId) {
        FastValidator.start().notNull(updatePasswordRequest.getOldPassword())
                .on(updatePasswordRequest.getNewPassword(), 8, 16);
        //两次密码是否一致
        isRightPassword(updatePasswordRequest.getNewPassword(), updatePasswordRequest.getConfirmPassword());
        //验证旧密码是否正确
        User user = isExistUser(userId, null, null);
        isRightPassword(user.getPassword(), updatePasswordRequest.getOldPassword());

        UserDto userDto = new UserDto();
        userDto.setId(userId);
        userDto.setPassword(updatePasswordRequest.getNewPassword().toLowerCase());
        userService.UpdateUser(userDto);
    }

    @Override
    public void resetPassword(ResetPasswordRequest resetPasswordRequest) {
        FastValidator.start().on(resetPasswordRequest.getNewPassword(), 8 , 16)
                .notNull(resetPasswordRequest.getTelphone())
                .notNull(resetPasswordRequest.getCode());
        //手机验证码是否正确
        TelphoneCodeRequest telphoneCodeRequest = new TelphoneCodeRequest(resetPasswordRequest.getTelphone(),
                resetPasswordRequest.getCode());
        isRightCode(telphoneCodeRequest);
        //两次密码是否一致
        isRightPassword(resetPasswordRequest.getNewPassword(), resetPasswordRequest.getConfirmPassword());

        User user = isExistUser(null, resetPasswordRequest.getTelphone(), null);
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setPassword(resetPasswordRequest.getNewPassword());
        userService.UpdateUser(userDto);
    }

    @Override
    public void resetTelphone(TelphoneCodeRequest telphoneCodeRequest, Long userId) {
        //存在该手机号码用户报错
        bizValidator.isExistUser(null, telphoneCodeRequest.getTelphone(), null);
        //手机验证码是否一致
        isRightCode(telphoneCodeRequest);

        UserDto userDto = new UserDto();
        userDto.setId(userId);
        userDto.setPassword(telphoneCodeRequest.getTelphone());
        userService.UpdateUser(userDto);
    }

    @Override
    public Boolean updateUserDetail(UserDetailRequest request, Long userId) {
        //TODO 后期对修改用户名是否有非法昵称做校验
        UserDto userDto = new UserDto();
        userDto.setId(userId);
        if (!StringUtils.isEmpty(request.getNickName())) {
            userDto.setNickName(request.getNickName());
        }
        if (!StringUtils.isEmpty(request.getUserName())) {
            userDto.setUserName(request.getUserName());
        }
        if (null != request.getGender()) {
            userDto.setGender(request.getGender());
        }
        if (!StringUtils.isEmpty(request.getHash())) {
            userDto.setUserImage(request.getHash());
        }
        userService.UpdateUser(userDto);

        return true;
    }

    @Override
    public void deleteByTel(String telphone) {
        String cacheKey = getCacheKey(telphone, Constant.ERROR_NUM);
        try {
            redisTemplate.delete(cacheKey);
        } catch (Exception e) {
            throw new ManagerException(ErrorCodeEnum.USER_LOCK);
        }
    }

    private String getCacheKey(String telphone, String type) {
        return Constant.APP_NAME + type + telphone;
    }

    /*
     *验证密码是否正确
     */
    private void  isRightPassword(String pwd, String inputPwd) {
        if (!pwd.toLowerCase().equals(inputPwd.toLowerCase())) {
            throw new ManagerException(ErrorCodeEnum.USER_PASSWORD_ERROR);
        }
    }

    /*
     * 根据手机号码找到用户信息
     */
    private User isExistUser(Long userId, String telphone, String emailAdress) {
        //账号是否存在
        User user = userService.getUser(userId, telphone, emailAdress);
        if (null == user) {
            throw new ManagerException(ErrorCodeEnum.USER_NOT_EXIST);
        }
        return user;
    }

    /*
     *发送手机验证码
     */
    private void sendTelCode(String telphone) {
        FastValidator.start().regTelphone(telphone);
        String code = String.valueOf(RandomUtils.nextInt(Constant.DEFAULT_CODE_LENGTH));
        //发送验证码一天不超过三次
        String cacheKey = getCacheKey(telphone, "sms");
        String errorNum = (String) redisTemplate.opsForValue().get(cacheKey);
        Integer num = 0;
        if (!StringUtils.isEmpty(errorNum)) {
            num = Integer.valueOf(errorNum);
        }
        if (num >= Constant.SEND_CODE_NUMBER) {
            throw new ManagerException(ErrorCodeEnum.SEND_CODE_LIMIT);
        }

        //调用第三方接口发送短信
        Map params = new HashMap();//请求参数
        params.put("mobile",telphone);//接收短信的手机号码
        params.put("tpl_id", SmsConfig.TEMPLATE_ID);//短信模板ID，请参考个人中心短信模板设置
        params.put("tpl_value",SmsConfig.TEL_CODE + code);//变量名和变量值对。
        params.put("key",SmsConfig.SMS_APPKEY);//应用APPKEY(应用详细页查询)

        try {
            String result =SmsConfig.net(params, "POST");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                //发送成功，记录发送条数
                num++;
                if (num == Constant.SEND_CODE_NUMBER) {
                    redisTemplate.opsForValue().set(cacheKey, num.toString());
                    redisTemplate.expire(cacheKey, 24, TimeUnit.HOURS);
                } else {
                    redisTemplate.opsForValue().set(cacheKey, num.toString());
                    redisTemplate.expire(cacheKey, 1, TimeUnit.HOURS);
                }
                //保存验证码
                String codeKey = getCacheKey(telphone, "code");
                redisTemplate.opsForValue().set(codeKey, code.toLowerCase());
                redisTemplate.expire(cacheKey, 5, TimeUnit.MINUTES);
            }else{
                throw new ManagerException(ErrorCodeEnum.SEND_CODE_FAILED);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
    