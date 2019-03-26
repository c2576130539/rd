package com.cc.rd.service.catpcha.impl;

import com.alibaba.fastjson.JSONObject;
import com.cc.rd.dto.CaptchaToken;
import com.cc.rd.enums.ErrorCodeEnum;
import com.cc.rd.exception.ManagerException;
import com.cc.rd.service.catpcha.CaptchaTokenService;
import com.cc.rd.util.EncryptUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

/**
 * @program: CaptchaTokenServiceImpl
 * @description:
 * @author: cchen
 * @create: 2019-03-06 17:15
 */
@Service
@Slf4j
public class CaptchaTokenServiceImpl implements CaptchaTokenService {

    private static final Logger logger = LoggerFactory.getLogger(CaptchaTokenServiceImpl.class);

    @Override
    public String encodeToken(CaptchaToken tokenObject) {
        String json;
        try {
            json = JSONObject.toJSONString(tokenObject);
        } catch (Exception ex) {
            logger.error("CAPTCHA|encodeToken|N|json error|{}", tokenObject, ex);
            throw new ManagerException(ErrorCodeEnum.CAPTCHA_CREATE_FAILED);
        }

        String jsonPayload = Base64Utils.encodeToString(json.getBytes());
        return EncryptUtils.encrypt(jsonPayload);
    }

    @Override
    public CaptchaToken decodeToken(String encodedString) {
        String base64 = EncryptUtils.decrypt(encodedString);
        if (StringUtils.isEmpty(base64)) {
            logger.error("CAPTCHA|decode|N|decrypt|{}", encodedString);
            return null;
        }

        String base64Decode = new String(Base64Utils.decodeFromString(base64));
        if (StringUtils.isEmpty(base64Decode)) {
            logger.error("CAPTCHA|decode|N|base64|{}", encodedString);
            return null;
        }

        try {
            return JSONObject.parseObject(base64Decode, CaptchaToken.class);
        } catch (Exception ex) {
            logger.error("CAPTCHA|decode|N|json|{}", encodedString);
            return null;
        }
    }
}
    