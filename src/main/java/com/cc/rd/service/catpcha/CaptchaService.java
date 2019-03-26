package com.cc.rd.service.catpcha;

import com.cc.rd.vo.user.CaptchaVO;

/**
 * @program: CaptchaService
 * @description: 验证码
 * @author: cchen
 * @create: 2019-03-06 14:10
 */
public interface CaptchaService {

    String generateCode();

    CaptchaVO getImg();

    Boolean checkCode(String captchaToken, String code);
}