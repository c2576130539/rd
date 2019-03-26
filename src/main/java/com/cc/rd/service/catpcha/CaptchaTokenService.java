package com.cc.rd.service.catpcha;

import com.cc.rd.dto.CaptchaToken;

/**
 * @program: CaptchaTokenService
 * @description:
 * @author: cchen
 * @create: 2019-03-06 17:14
 */
public interface CaptchaTokenService {

    String encodeToken(CaptchaToken tokenObject);

    CaptchaToken decodeToken(String encodedString);
}