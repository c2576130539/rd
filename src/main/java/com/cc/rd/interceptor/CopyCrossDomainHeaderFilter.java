package com.cc.rd.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: CopyCrossDomainHeaderFilter
 * @description: 解决跨域问题
 * @author: cchen
 * @create: 2019-03-08 20:31
 */
@Component
@Slf4j
@Order(2)
public class CopyCrossDomainHeaderFilter extends OncePerRequestFilter{

    private final static String HEADERS_ORIGIN = "Origin";
    private final static String HEADERS_CROSS_DOMAIN = "Access-Control-Allow-Origin";

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws ServletException, IOException {
        String reqHeaderOrigin = req.getHeader(HEADERS_ORIGIN);

        if (StringUtils.isNotEmpty(reqHeaderOrigin)) {
            try {
                resp.setHeader(HEADERS_CROSS_DOMAIN, reqHeaderOrigin);
                resp.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Accept, Range,Authorization");
                resp.setHeader("Access-Control-Allow-Credentials", "true");
                resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, HEAD, TRACE, DELETE, PATCH");
            } catch (Exception ex) {
                log.error("Set Cross Domain Header Failed, {}", ex);
            }
        }

        filterChain.doFilter(req, resp);
    }
}
    