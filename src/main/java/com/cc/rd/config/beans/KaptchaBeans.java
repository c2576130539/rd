package com.cc.rd.config.beans;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @program: KaptchaBeans
 * @description: Kaptcha验证码配置
 * @author: cchen
 * @create: 2019-03-08 11:17
 */
@Configuration
public class KaptchaBeans {

    @Bean
    public Config captchaConfig() {
        Properties p = new Properties();
        p.setProperty("kaptcha.image.width", "100");
        p.setProperty("kaptcha.image.height", "48");
        return new Config(p);
    }

    @Bean
    public Producer captchaProducer() {
        DefaultKaptcha p = new DefaultKaptcha();
        p.setConfig(captchaConfig());
        return p;
    }

}
    