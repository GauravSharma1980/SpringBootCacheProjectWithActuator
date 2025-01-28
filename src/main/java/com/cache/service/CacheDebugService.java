package com.cache.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CacheDebugService {

    private final CacheManager cacheManager;


    public CacheDebugService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void printCacheContents(String cacheName){
        Cache cache = cacheManager.getCache(cacheName);
        if(cache != null){
            log.info("Cache content for {}",cacheName );
            log.info("{}",cache.getNativeCache().toString());
        }else {
            log.info("cache with name {} not found",cacheName);
        }
    }
}
