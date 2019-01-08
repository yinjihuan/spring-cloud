package com.fangjia.fsh.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author yinjihuan
 * @create 2017-12-08 18:44
 **/
@Configuration
public class RedisConfig {

    @Autowired
    JedisConnectionFactory jedisConnectionFactory;

    @Bean(name = "longRedisTemplate")
    public RedisTemplate<String, Long> redisTemplate() {
        RedisTemplate<String, Long> template = new RedisTemplate<String, Long>();
        template.setConnectionFactory(jedisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericToStringSerializer< Long >( Long.class ) );
        template.setValueSerializer(new GenericToStringSerializer< Long >( Long.class ) );
        return template;
    }
}
