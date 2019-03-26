package com.cc.rd.controller.user;

import com.cc.rd.enums.ErrorCodeEnum;
import com.cc.rd.exception.ManagerException;
import com.cc.rd.request.CaptchaCheckRequest;
import com.cc.rd.service.catpcha.CaptchaService;
import com.cc.rd.util.JSONResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @program: CaptchaController
 * @description: 验证码Captcha
 * @author: cchen
 * @create: 2019-03-06 13:45
 */
@Api(description = "图片验证码")
@RestController
public class CaptchaController {

    @Autowired
    private CaptchaService captchaService;

    @GetMapping("/captcha")
    public JSONResult get(HttpServletResponse response) {
        response.addHeader(HttpHeaders.CACHE_CONTROL, CacheControl.noStore().getHeaderValue());
        return JSONResult.success(captchaService.getImg());
    }

    @PostMapping("/captcha")
    public JSONResult check(@RequestBody CaptchaCheckRequest request) {
        if (null == request) {
            throw new ManagerException(ErrorCodeEnum.CAPTCHA_FAILED);
        }
        return JSONResult.success(captchaService.checkCode(request.getToken(), request.getCode()));
    }
}
    