package com.cc.rd.request.user;

import lombok.Data;

/**
 * @program: TelphoneCodeRequest
 * @description: 手机验证码
 * @author: cchen
 * @create: 2019-03-10 09:18
 */
@Data
public class TelphoneCodeRequest {

    private String telphone;

    private String code;

    public TelphoneCodeRequest () {}

    public TelphoneCodeRequest (String telphone, String code) {
        this.telphone = telphone;
        this.code = code;
    }
}
    