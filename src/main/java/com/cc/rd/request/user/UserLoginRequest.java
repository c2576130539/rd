package com.cc.rd.request.user;

import com.cc.rd.request.CaptchaCheckRequest;
import lombok.Data;

/**
 * @program: UserLoginRequest
 * @description: 手机用户登陆请求参数
 * @author: cchen
 * @create: 2019-03-06 10:10
 */
@Data
public class UserLoginRequest extends CaptchaCheckRequest {

    private String telphone;

    private String password;
}
    