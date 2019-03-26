package com.cc.rd.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.auth0.jwt.interfaces.Claim;
import com.cc.rd.enums.Constant;
import com.cc.rd.enums.ErrorCodeEnum;
import com.cc.rd.service.user.LogOutService;
import com.cc.rd.util.JSONResult;
import com.cc.rd.util.JwtUtils;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @program: JwtAuthFilter
 * @description: token拦截验证
 * @author: cchen
 * @create: 2019-03-08 14:23
 */
@Component
@Slf4j
@Order(1)
public class JwtAuthFilter extends OncePerRequestFilter {

    private final static List<RequestMatcher> antRequestMatchers = Lists.newArrayList();

    @Autowired
    private LogOutService logOutService;

    static {
        String[] paths = new String[]{
                "/webjars/**",
                "/swagger-resources/**",
                "/swagger-ui.html",
                "/v2/api-docs",
                "/error",
                "/captcha",
                "/accounts/**"
        };

        antRequestMatchers.add(new AntPathRequestMatcher("**", "OPTIONS"));
        for (String path : paths) {
            antRequestMatchers.add(new AntPathRequestMatcher(path));
        }
    }

    static class IgnoredAuthenticationToken implements Authentication {

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
        }

        @Override
        public Object getCredentials() {
            return null;
        }

        @Override
        public Object getDetails() {
            return null;
        }

        @Override
        public Object getPrincipal() {
            return null;
        }

        @Override
        public boolean isAuthenticated() {
            return true;
        }

        @Override
        public void setAuthenticated(boolean b) throws IllegalArgumentException {

        }

        @Override
        public String getName() {
            return null;
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        for (RequestMatcher matcher : antRequestMatchers) {
            if (matcher.matches(httpServletRequest)) {
                SecurityContextHolder.getContext().setAuthentication(new IgnoredAuthenticationToken());
                filterChain.doFilter(httpServletRequest, httpServletResponse);
                return;
            }
        }

        if (isSkipChecking(httpServletRequest)) {
            SecurityContextHolder.getContext().setAuthentication(new IgnoredAuthenticationToken());
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        String token = httpServletRequest.getHeader("Authorization");

        if (StringUtils.isEmpty(token)) {
            log.error("token validate failed, no auth info in http header");
            setNoAuth(httpServletResponse);
            return;
        }

        String[] codes = token.split("\\.");

        if (codes.length < 2) {
            log.error("token validate failed, format error");
            setNoAuth(httpServletResponse);
            return;
        }

        try {
            Map<String, Claim> map = JwtUtils.verify(token);

            if (CollectionUtils.isEmpty(map)) {
                setNoAuth(httpServletResponse);
                return;
            }

            if (null == map.get("userId")) {
                setNoAuth(httpServletResponse);
                return;
            }

            String userId = map.get("userId").asString();
            if (StringUtils.isEmpty(userId)) {
                setNoAuth(httpServletResponse);
                return;
            }

            // 查看之前是否已经登出
            if (logOutService.isLoggedOut(userId)) {
                log.error("已经登出的用户, userName={}", userId);
                setNoAuth(httpServletResponse);
                return;
            }

            // token verified success
            // load user detail into authenticate
            SecurityContextHolder.getContext().setAuthentication(new IgnoredAuthenticationToken());
        } catch (Exception ex) {
            log.error("JWT验证失败 {}", token, ex);
            setNoAuth(httpServletResponse);
            return;
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    /**
     * jwt check failed
     *
     * @param response
     * @throws IOException
     */
    private void setNoAuth(HttpServletResponse response) throws IOException {
        JSONResult result = new JSONResult(ErrorCodeEnum.NEED_LOGIN, HttpStatus.UNAUTHORIZED.value());
        response.setHeader("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.getWriter().write(JSONObject.toJSONString(result, SerializerFeature.WriteMapNullValue));
    }

    /**
     * 内部服务调用可以通过添加header来绕过
     *
     * @param req
     * @return
     */
    private boolean isSkipChecking(HttpServletRequest req) {
        String internalToken = req.getHeader("df_internal_token");
        return StringUtils.isNotEmpty(internalToken) && internalToken.equals(Constant.INTERNAL_TOKEN);
    }
}
    