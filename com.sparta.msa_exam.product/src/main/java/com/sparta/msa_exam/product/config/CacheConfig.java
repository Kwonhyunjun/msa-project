package com.sparta.msa_exam.product.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfig {

    // CacheManager 등록
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
        // 먼저 설정 구성
        // RedisCacheConfiguration - Redis를 이용해서 Spring Cache를 사용할 때 Redis 관련 설정을 모아두는 클래스
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration
                .defaultCacheConfig()
                .disableCachingNullValues() // null 캐싱 여부
                .entryTtl(Duration.ofSeconds(60)) // TTL(Time To Live) 기본 캐시 유지 시간 설정
                .computePrefixWith(CacheKeyPrefix.simple()) // 캐시를 구분하는 접두사 설정
                .serializeValuesWith( // 캐시에 저장할 값을 어떻게 직렬화 & 역직렬화 할 것인지 설정
                        RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.java())
                );

        // 구성한 설정을 기반으로 CacheManager 반환
        return RedisCacheManager
                .builder(redisConnectionFactory)
                .cacheDefaults(redisCacheConfiguration)
                .build();
    }

}
