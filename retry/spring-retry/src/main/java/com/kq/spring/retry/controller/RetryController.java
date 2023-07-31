package com.kq.spring.retry.controller;

import com.kq.spring.retry.api.OrderServiceApi;
import com.kq.spring.retry.dto.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


/**
 * RetryController
 *
 * @author kq
 * @date 2023-07-31 23:40
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/retry")
public class RetryController {

    @Autowired
    private OrderServiceApi orderServiceApi;

    @Value("${server.port}")
    private int port;


    private AtomicLong atomicLong = new AtomicLong();

    @GetMapping("/info")
    public String getInfo(){

        log.info("call /retry/info");

        String address = "http://localhost:"+port+"/retry/test";

        Map<String, String> map = new HashMap<>();
        map.put("name", "admin");
        map.put("hobby", "football");
        try {

            orderServiceApi.getRequest(map,address);
        }catch (Exception e) {
            log.error("接口调用报错 ",e);
            log.error("接口调用报错 map={}",map,e);
        }

        return "ok";
    }


    @GetMapping("/test")
    public String getTest(UserRequest request){

        log.info("call /retry/test  index={} , data:{}",atomicLong.incrementAndGet(),request);
        try {
            Thread.sleep(5000L);
        }catch (Exception e){
            log.error("",e);
        }

        return "ok";
    }


}

