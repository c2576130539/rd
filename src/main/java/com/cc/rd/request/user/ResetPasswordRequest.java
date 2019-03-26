package com.cc.rd.request.user;

import lombok.Data;

/**
 * @program: ResetPasswordRequest
 * @description: 找回密码
 * @author: cchen
 * @create: 2019-03-07 22:18
 */
@Data
public class ResetPasswordRequest extends TelphoneCodeRequest {
    
    private String newPassword;
    
    private String confirmPassword;
}
    