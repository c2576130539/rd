package com.cc.rd.controller;

import com.auth0.jwt.interfaces.Claim;
import com.cc.rd.util.JwtUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @program: BaseController
 * @description:
 * @author: cchen
 * @create: 2019-03-07 15:38
 */
public class BaseController {

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.response = response;
        this.request = request;
    }


    /**
     * 获取当前用户id
     *
     * @return
     */
    public String getUserId() {
        String token = request.getHeader("Authorization");
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        Map<String, Claim> map = JwtUtils.verify(token);

        if (CollectionUtils.isEmpty(map)) {
            return null;
        }
        return map.get("userId").asString();
    }

    /**
     * 获取用户手机号码
     *
     * @return
     */
    public String getAccount() {
        String token = request.getHeader("Authorization");
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        Map<String, Claim> map = JwtUtils.verify(token);

        if (CollectionUtils.isEmpty(map)) {
            return null;
        }
        return map.get("telphone").asString();
    }

    /**
     * 设置响应为文件
     *
     * @param fileName
     * @throws IOException
     */
    public void setResponseFile(String fileName) throws IOException {
        this.response.addHeader("Content-Disposition",
                "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
        this.response.setContentType("application/octet-stream");
        this.response.flushBuffer();
    }
}
    