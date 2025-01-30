package com.cache.controller;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/products")
public class CacheController {

    private final CacheManager cacheManager;

    @GetMapping("/cache")
    public Object getCacheContent(@RequestParam String cacheName){
        log.info("{} method get called","getCacheContent");
        Cache cache = cacheManager.getCache(cacheName);
        if(null == cache) {
            return "Cache not found";
        }
        log.info("in method {} , the cache {} is not empty","getCacheContent",cacheName);
        ConcurrentMap<Object,Object> nativeCache = (ConcurrentMap<Object,Object>) cache.getNativeCache();
        return nativeCache;
    }
}
