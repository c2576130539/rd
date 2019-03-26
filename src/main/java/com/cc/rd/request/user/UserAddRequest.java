package com.cc.rd.request.user;

import com.cc.rd.request.CaptchaCheckRequest;
import lombok.Data;

/**
 * @program: UserAddRequest
 * @description: 手机用户注册请求参数
 * @author: cchen
 * @create: 2019-03-06 10:09
 */
@Data
public class UserAddRequest extends TelphoneCodeRequest {

    private Integer authenticationSource;

    private String password;

    private String confirmPassword;

}
    