package com.cc.rd.service.catpcha.impl;

import com.cc.rd.dto.CaptchaToken;
import com.cc.rd.enums.Constant;
import com.cc.rd.enums.ErrorCodeEnum;
import com.cc.rd.exception.ManagerException;
import com.cc.rd.service.catpcha.CaptchaImageService;
import com.cc.rd.service.catpcha.CaptchaService;
import com.cc.rd.service.catpcha.CaptchaTokenService;
import com.cc.rd.validator.FastValidator;
import com.cc.rd.vo.user.CaptchaVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: CaptchaServiceImpl
 * @description: 验证码逻辑实现
 * @author: cchen
 * @create: 2019-03-06 14:27
 */
@Service
@Slf4j
public class CaptchaServiceImpl implements CaptchaService {

    private static final Logger logger = LoggerFactory.getLogger(CaptchaServiceImpl.class);

    private final static char[] POSSIBLE_CHARS = "ABCDEFGHKMNPQRTUVWXY346789".toCharArray();

    @Autowired
    private CaptchaImageService imageService;

    @Autowired
    private CaptchaTokenService captchaTokenService;

    @Override
    public String generateCode() {
        char[] chars = new char[Constant.DEFAULT_CODE_LENGTH];
        for (int i = 0; i < Constant.DEFAULT_CODE_LENGTH; i++) {
            int p = RandomUtils.nextInt(0, POSSIBLE_CHARS.length);
            chars[i] = POSSIBLE_CHARS[p];
        }
        return new String(chars);
    }

    @Override
    public CaptchaVO getImg() {
        String code = generateCode();
        String base64Image;
        try {
            base64Image = imageService.getImageBase64(code);
        } catch (Exception e) {
            logger.error("CAPTCHA|genImg|N|{}", code, e);
            throw new ManagerException(ErrorCodeEnum.CAPTCHA_CREATE_FAILED);
        }

        if (StringUtils.isEmpty(base64Image)) {
            throw new ManagerException(ErrorCodeEnum.CAPTCHA_CREATE_FAILED);
        }

        CaptchaToken captchaToken = new CaptchaToken();

        captchaToken.setCode(code);

        String token = captchaTokenService.encodeToken(captchaToken);

        if (StringUtils.isEmpty(token)) {
            throw new ManagerException(ErrorCodeEnum.TOKEN_CREATE_FAILED);
        }

        logger.info("CAPTCHA|getImg|token={}, code={}", token, code);

        CaptchaVO captchaVO = new CaptchaVO();
        captchaVO.setToken(token);
        captchaVO.setBase64Img(base64Image);
        return captchaVO;
    }

    @Override
    public Boolean checkCode(String captchaToken, String code) {
        FastValidator.start().notNull(captchaToken, "CaptchaToken")
                .notNull(code, "code");

        CaptchaToken token = captchaTokenService.decodeToken(captchaToken);
        if (null == token || token.isInvalid()) {
            logger.error("CAPTCHA|decode|invalid|{}", captchaToken);
            throw new ManagerException(ErrorCodeEnum.INVALID_INPUT_PARAM, "Token is invalid");
        }

        String yours = code.toUpperCase();
        String mine = token.getCode().toUpperCase();

        boolean isChallengeSucceed = StringUtils.equals(yours, mine);

        if (isChallengeSucceed) {
            return true;
        } else {
            throw new ManagerException(ErrorCodeEnum.CAPTCHA_FAILED);
        }
    }
}
    