package com.kq.spring.retry.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.impl.client.HttpClients;

/**
 * OrderServiceApi
 *
 * @author kq
 * @date 2023-07-31 23:37
 * @since 1.0.0
 */
@Slf4j
@Component
public class OrderServiceApi {

    @Resource
    private RestTemplate restTemplate;

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Retryable(value = RestClientException.class, maxAttempts = 3,
            backoff = @Backoff(delay = 1000L,multiplier = 2))
    public String getRequest(Map<String, String> map,String address) {
        log.info("发起远程API 地址: {} ,请求事件: {}", address, DATE_TIME_FORMATTER.format(LocalDateTime.now()));


        ResponseEntity<String> responseEntity = restTemplate.getForEntity(address+"?name={name}&hobby={hobby}", String.class, map);

        // 获取响应结果
        return responseEntity.getBody();
    }



}
