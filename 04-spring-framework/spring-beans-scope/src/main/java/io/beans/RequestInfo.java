package io.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestInfo {
    private String requestId = UUID.randomUUID().toString();
    private String userAgent;
    private String clientIp;
    private long startTime = System.currentTimeMillis();

    public void logRequest(String url){
        System.out.println("Request: "+ requestId + " to "+ url);
    }
}
