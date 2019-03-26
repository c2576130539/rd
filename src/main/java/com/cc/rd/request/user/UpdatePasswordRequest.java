package com.cc.rd.request.user;

import lombok.Data;

/**
 * @program: UpdatePasswordRequest
 * @description: 修改密码请求参数
 * @author: cchen
 * @create: 2019-03-06 19:53
 */
@Data
public class UpdatePasswordRequest {

    private String oldPassword;

    private String newPassword;

    private String confirmPassword;

}
    