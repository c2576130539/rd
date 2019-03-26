package com.cc.rd.service.catpcha;

/**
 * @program: CaptchaImageService
 * @description: 验证码图片资源
 * @author: cchen
 * @create: 2019-03-06 15:01
 */
public interface CaptchaImageService {

    String getImageBase64(String code);
}