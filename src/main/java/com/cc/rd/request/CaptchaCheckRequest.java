package com.cc.rd.request;

import lombok.Data;

/**
 * @program: CaptchaCheckRequest
 * @description: 验证码验证请求参数
 * @author: cchen
 * @create: 2019-03-06 15:34
 */
@Data
public class CaptchaCheckRequest {

    private String code;

    private String token;
}
    