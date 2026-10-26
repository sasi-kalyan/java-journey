package com.service.discovery.order_service.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "product-service",
        url = "http://localhost:8083"
)
public interface ProductClient {

    @GetMapping("/api/products/invoke-order")
    String invokeNewProduct();
}
