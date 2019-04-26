package com.cc.rd.dto;

import lombok.Data;

/**
 * @program: UserDto
 * @description: 用户数据传输对象
 * @author: cchen
 * @create: 2019-03-05 17:36
 */
@Data
public class UserDto {

    private Long id;

    private String userName;

    private String nickName;

    private Integer gender;

    private String telphone;

    private String password;

    private String emailAddress;

    private String code;

    private Long money;

    private Integer credit;

    private String userImage;

}
    