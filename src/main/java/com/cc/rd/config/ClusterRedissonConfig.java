package com.cc.rd.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @program: ClusterRedissonConfig
 * @description: 集群redis
 * @author: cchen
 * @create: 2019-03-02 11:32
 */
public class ClusterRedissonConfig {

    @Value("localhost:7000,localhost:7001,localhost:7002")
    private String redisHosts;

    @Value("${redis_pass:}")
    private String redisPass;

    @Bean
    public Config config() {
        Config config = new Config();
        String[] hosts = redisHosts.split(",");

        for (int i=0; i<hosts.length; i++) {
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
        return Redisson.create(config()) ;
    }
}
    