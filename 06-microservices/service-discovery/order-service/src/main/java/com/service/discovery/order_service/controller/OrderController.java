package com.service.discovery.order_service.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
@EnableFeignClients
public class OrderController {

    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    private final WebClient webClient;

    private final ProductClient productClient;


    public OrderController(@LoadBalanced RestTemplate restTemplate, DiscoveryClient discoveryClient, WebClient webClient, ProductClient productClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
        this.webClient = webClient;
        this.productClient = productClient;
    }

    @GetMapping("/instances")
    public List<ServiceInstance> instances(){
        return discoveryClient.getInstances("product-service");
    }


    @GetMapping("/plaece-order")
    public Object placeOrder(){
        var products = restTemplate.getForObject(
                "http://product-service/api/products", List.class);

        return Map.of("orderId", UUID.randomUUID().toString(), "products", products);
    }

    @GetMapping("/invoke-order")
    public Mono<String> invokeOrder(){
        return webClient.get()
                .uri("/api/products/invoke-order")
                .retrieve()
                .bodyToMono(String.class);
    }


    @GetMapping("/new-product")
    public void getNewProduct(){
        String result = productClient.invokeNewProduct();
        System.out.println(result);
    }


}
