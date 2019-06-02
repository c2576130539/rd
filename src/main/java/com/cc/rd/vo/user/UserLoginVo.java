package com.cc.rd.vo.user;

import lombok.Data;

/**
 * @program: UserLoginVo
 * @description: 登陆返回数据
 * @author: cchen
 * @create: 2019-03-07 20:26
 */
@Data
public class UserLoginVo {

    private String token;

    private String nickName;

    private String gender;

    private String telphone;

    private String money;

    private String credit;

    private String userImage;

}
    