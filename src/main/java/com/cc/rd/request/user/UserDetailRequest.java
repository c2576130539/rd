package com.cc.rd.request.user;

import lombok.Data;

/**
 * @program: UserDetailRequest
 * @description: 修改用户详情
 * @author: cchen
 * @create: 2019-03-08 07:51
 */
@Data
public class UserDetailRequest {

    private String userName;

    private String nickName;

    private Integer gender;

    /**
     * 头像
     */
    private String hash;
}
    