package com.dzhao.exams.spring.ehcache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.DefaultKeyGenerator;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzhao on 2/05/2016.
 */
@Configuration
@EnableCaching
public class CatchingConfig implements CachingConfigurer{

    @Qualifier("ehCacheCacheManager")
    @Autowired(required = false)
    private CacheManager ehCacheCacheManager;

    public CacheManager cacheManager() {
        List<CacheManager> cacheManagers = new ArrayList<CacheManager>();

        if (this.ehCacheCacheManager != null) {
            cacheManagers.add(this.ehCacheCacheManager);
        }

        CompositeCacheManager cacheManager = new CompositeCacheManager();

        cacheManager.setCacheManagers(cacheManagers);
        cacheManager.setFallbackToNoOpCache(false);

        return cacheManager;
    }

    public CacheResolver cacheResolver() {
        return null;
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return new DefaultKeyGenerator();
    }

    public CacheErrorHandler errorHandler() {
        return null;
    }
}
