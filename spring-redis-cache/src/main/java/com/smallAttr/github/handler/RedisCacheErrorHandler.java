package com.smallAttr.github.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.SimpleCacheErrorHandler;
import org.springframework.stereotype.Component;

/**
 * @Author: chenGang
 * @Date: 2018/6/9 上午1:03
 * @Description:
 */
@Component
public class RedisCacheErrorHandler extends SimpleCacheErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(RedisCacheErrorHandler.class);
    public RedisCacheErrorHandler() {
        super();
    }

    @Override
    public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
        super.handleCacheGetError(exception, cache, key);
    }

    @Override
    public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
        super.handleCachePutError(exception, cache, key, value);
    }

    @Override
    public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
        super.handleCacheEvictError(exception, cache, key);
    }

    @Override
    public void handleCacheClearError(RuntimeException exception, Cache cache) {
        super.handleCacheClearError(exception, cache);
    }
}
