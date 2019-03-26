package com.cc.rd.vo.user;

import lombok.Data;

/**
 * @program: CaptchaVO
 * @description: 验证码返回参数
 * @author: cchen
 * @create: 2019-03-06 14:25
 */
@Data
public class CaptchaVO {
    private String base64Img;

    private String token;
}
    