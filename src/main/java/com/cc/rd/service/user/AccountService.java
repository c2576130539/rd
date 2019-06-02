package com.cc.rd.service.user;

import com.cc.rd.request.user.*;
import com.cc.rd.vo.user.UserLoginVo;

/**
 * @program: AccountService
 * @description: 账号逻辑接口
 * @author: cchen
 * @create: 2019-03-05 19:01
 */
public interface AccountService {

    /**
     * 获取当前用户登陆信息
     * @param userId
     * @return
     */
    UserLoginVo getLoginUser(Long userId);

    /**
     * 验证手机验证码是否正确
     */
    Boolean isRightCode(TelphoneCodeRequest telphoneCodeRequest);

    /**
     * 为新注册的用户发送手机验证码
     * @param telphone
     */
    Boolean newUserCode(String telphone);

    /**
     * 为已存在的用户发送手机验证码
     * @param telphone
     */
    Boolean oldUserCode(String telphone);

    /**
     * 注册
     * @param userAddRequest
     */
    Boolean registerUser(UserAddRequest userAddRequest);

    /**
     * 登陆
     * @param userLoginRequest
     * @return
     */
    UserLoginVo login(UserLoginRequest userLoginRequest);

    /**
     * 根据旧密码该新密码
     * @param updatePasswordRequest
     * @param userId
     */
    Boolean updatePassword(UpdatePasswordRequest updatePasswordRequest, Long userId);

    /**
     * 找回密码
     * @param resetPasswordRequest
     */
    Boolean resetPassword(ResetPasswordRequest resetPasswordRequest);

    /**
     * 更换手机号码
     * @param telphoneCodeRequest
     * @param userId
     */
    Boolean resetTelphone(TelphoneCodeRequest telphoneCodeRequest, Long userId);

    /**
     * 更新用户信息
     * @param userDetailRequest
     * @param userId
     * @return
     */
    Boolean updateUserDetail(UserDetailRequest userDetailRequest, Long userId);

    /**
     * 解锁
     * @param telphone
     */
    Boolean deleteByTel(String telphone);

}