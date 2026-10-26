package com.service.discovery.product_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
@FeignClient(name = "product-service")
public class ProductController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/products")
    public List<Map<String, Object>> products(){
        return List.of(
                Map.of("id", 1, "Laptop", 1, "servedBy", port),
                Map.of("id", 1, "iPhone", 1, "servedBy", port)
        );
    }

    @GetMapping("/invoke-order")
    public String invokeOrder(){
        return "Order is initiated through (HTTP-Client) ---> WebClient";
    }


}
