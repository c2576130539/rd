package com.cc.rd.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @program: RedisConfig
 * @description: redis config
 * @author: cchen
 * @create: 2019-03-02 11:16
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis.cluster")
@Data
public class RedisConfig {

    List<String> nodes;
}
    