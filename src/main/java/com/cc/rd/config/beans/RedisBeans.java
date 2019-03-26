package com.cc.rd.config.beans;

import com.cc.rd.config.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @program: RedisBeans
 * @description:
 * @author: cchen
 * @create: 2019-03-02 11:21
 */
@Configuration
public class RedisBeans {

    @Autowired
    private RedisConfig redisConfig;

    @Value("${redis_pass:redis_df_123}")
    private String redisPassword;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisClusterConfiguration config = new RedisClusterConfiguration(redisConfig.getNodes());
        config.setPassword(RedisPassword.of(redisPassword));
        return new JedisConnectionFactory(config);
    }

    @Bean
    public RedisTemplate redisTemplate() {
        return new StringRedisTemplate(redisConnectionFactory());
    }
}

    