package com.cc.rd.service.catpcha.impl;

import com.cc.rd.service.catpcha.CaptchaImageService;
import lombok.extern.slf4j.Slf4j;
import com.google.code.kaptcha.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * @program: CaptchaImageServiceImpl
 * @description:
 * @author: cchen
 * @create: 2019-03-06 15:02
 */
@Service
@Slf4j
public class CaptchaImageServiceImpl implements CaptchaImageService {

    private static final Logger logger = LoggerFactory.getLogger(CaptchaImageServiceImpl.class);

    @Autowired
    private Producer kaptchaProduer;

    @Override
    public String getImageBase64(String code) {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage image = kaptchaProduer.createImage(code);
            ImageIO.write(image, "PNG", bos);
            return Base64Utils.encodeToString(bos.toByteArray());
        }catch (Exception e) {
            logger.error("CAPTCHA|genImg|N|{}", code, e);
            return null;
        }
    }
}
    