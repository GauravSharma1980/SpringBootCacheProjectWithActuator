package com.cache.service;

import com.cache.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductService {

    @Cacheable("products")
    public Product getProductById(Long id) {
        log.info("{} method called ", "getProductById");

        simulateSlowService();
        return new Product(id, "Laptop", 1200);
    }

    private void simulateSlowService() {
        log.info("{} method called ", "simulateSlowService");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
