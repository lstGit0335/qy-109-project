package com.aaa.lwl.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * fileName:RedisClusterProperties
 * Author:李守堂
 * createTime:2020/7/13   15:06
 * version:1.0.0
 * Description
 */
@Component
@PropertySource("classpath:properties/redis_cluster.properties")
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisClusterProperties {
    private String nodes;
    private Integer maxAttempts;
    private Integer commandTimeout;
}
