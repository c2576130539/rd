package com.cc.rd.config.redisson;

import lombok.extern.slf4j.Slf4j;
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
@ConditionalOnProperty("redis_hosts")
public class ClusterRedissonConfig {

    @Value("${redis_hosts:localhost:7000,localhost:7001,localhost:7002}")
    private String redisHosts;

    @Value("${redis_pass:}")
    private String redisPass;

    @Bean
    public Config config() {
        Config config = new Config();
        config.setCodec(StringCodec.INSTANCE);
        String[] hosts = redisHosts.split(",");

        for (int i = 0; i < hosts.length; i++) {
            hosts[i] = "redis://" + hosts[i];
        }

        config.useClusterServers()
                .addNodeAddress(hosts)
                .setPassword(redisPass)
                .setTimeout(5000)
                .setKeepAlive(true)
                .setMasterConnectionPoolSize(10)
                .setMasterConnectionMinimumIdleSize(10)
                .setSlaveConnectionPoolSize(10)
                .setSlaveConnectionMinimumIdleSize(10);

        return config;
    }

    @Bean
    public RedissonClient redissonClient() {
        log.info("========================Redisson 集群模式=========================");
        return Redisson.create(config());
    }
}
