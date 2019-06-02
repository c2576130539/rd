package com.cc.rd.config.redisson;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@ConditionalOnProperty("redis_host")
public class SingleRedissonConfig {

    @Value("${redis_host:localhost:6379}")
    private String singleRedisHost;

    @Value("${redis_pass:}")
    private String singleRedisPassword;

    @Bean
    public Config config() {
        Config config = new Config();
        config.setCodec(StringCodec.INSTANCE);

        if (!StringUtils.startsWithIgnoreCase(singleRedisHost, "redis://")) {
            singleRedisHost = "redis://" + singleRedisHost;
        }
        config.useSingleServer()
                .setAddress(singleRedisHost)
                .setPassword(singleRedisPassword)
                .setTimeout(5000)
                .setConnectTimeout(5000);
        return config;
    }

    @Bean
    public RedissonClient redissonClient() {
        log.info("========================Redisson 单节点模式=========================");
        return Redisson.create(config());
    }
}
