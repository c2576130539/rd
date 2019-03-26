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
     * 验证手机验证码是否正确
     */
    void isRightCode(TelphoneCodeRequest telphoneCodeRequest);

    /**
     * 为新注册的用户发送手机验证码
     * @param telphone
     */
    void newUserCode(String telphone);

    /**
     * 为已存在的用户发送手机验证码
     * @param telphone
     */
    void oldUserCode(String telphone);

    /**
     * 注册
     * @param userAddRequest
     */
    void registerUser(UserAddRequest userAddRequest);

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
    void updatePassword(UpdatePasswordRequest updatePasswordRequest, Long userId);

    /**
     * 找回密码
     * @param resetPasswordRequest
     */
    void resetPassword(ResetPasswordRequest resetPasswordRequest);

    /**
     * 更换手机号码
     * @param telphoneCodeRequest
     * @param userId
     */
    void resetTelphone(TelphoneCodeRequest telphoneCodeRequest, Long userId);

    void updateUserDetail(UserDetailRequest userDetailRequest, Long userId);

    /**
     * 解锁
     * @param telphone
     */
    void deleteByTel(String telphone);

}