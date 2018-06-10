package com.smallAttr.github;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @Author: chenGang
 * @Date: 2018/6/9 上午1:02
 * @Description:
 */
@Configuration
@EnableCaching
public class CacheConfiguration {

    @Value("${memcached.server.host}")
    private String memcachedHost;

    @Value("${memcached.server.port}")
    private int memcachedPort;

    @Value("${memcached.server.weight}")
    private int memcachedWeight;



    @Bean
    public MemcachedClient memcachedClient() throws IOException {
        return new XMemcachedClient(new InetSocketAddress(memcachedHost, memcachedPort), memcachedWeight);
    }

}
