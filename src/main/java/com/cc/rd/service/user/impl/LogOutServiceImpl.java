package com.cc.rd.service.user.impl;

import com.cc.rd.enums.Constant;
import com.cc.rd.service.user.LogOutService;
import com.cc.rd.util.DateTimeUtils;
import com.cc.rd.util.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @program: LogOutServiceImpl
 * @description: 退出登录逻辑实现
 * @author: cchen
 * @create: 2019-03-08 15:22
 */
@Service
public class LogOutServiceImpl implements LogOutService {

    private static final Logger logger = LoggerFactory.getLogger(LogOutServiceImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Boolean setLogoutStatus(String userId) {
        if (StringUtils.isEmpty(userId)) {
            return false;
        }
        String key = Constant.REDIS_PREFIX_LOGGED_OUT_USER + MD5Utils.encodeMD5(userId);
        try {
            redisTemplate.opsForValue().set(key, String.valueOf(DateTimeUtils.utcNow()), Constant.ONE_MONTHS, TimeUnit.DAYS);
            logger.info("Account|setLogoutStatus Success|{}", userId);
            return true;
        } catch (Exception ex) {
            logger.error("Account|setLogoutStatus|{}", userId, ex);
            return false;
        }
    }

    @Override
    public Boolean clearLogoutStatus(String userId) {
        if (StringUtils.isEmpty(userId)) {
            return false;
        }

        String key = Constant.REDIS_PREFIX_LOGGED_OUT_USER + MD5Utils.encodeMD5(userId);
        try {
            redisTemplate.delete(key);
            logger.info("Account|clearLogoutStatus Success|{}", userId);
            return true;
        } catch (Exception ex) {
            logger.error("Account|clearLogoutStatus|{}", userId, ex);
            return false;
        }
    }

    @Override
    public Boolean isLoggedOut(String userId) {
        if (StringUtils.isEmpty(userId)) {
            return false;
        }

        String key = Constant.REDIS_PREFIX_LOGGED_OUT_USER + MD5Utils.encodeMD5(userId);
        try {
            return null != redisTemplate.opsForValue().get(key);
        } catch (Exception ex) {
            logger.error("Account|isLoggedOut|{}", userId, ex);
            return false;
        }
    }
}
    