package com.cache.controller;


import com.cache.entity.Product;
import com.cache.service.CacheDebugService;
import com.cache.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CacheDebugService cacheDebugService;

    @GetMapping(value = "/getProductDetails",produces = "application/json")
    public ResponseEntity<Product> getProductDetails(){
        log.info("{} is called ","getProductDetails");
        cacheDebugService.printCacheContents("products");
        Product product = productService.getProductById(10L);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
}
