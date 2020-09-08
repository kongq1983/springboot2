package com.kq.springdebug.resourcedi.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Map;

/**
 * @author kq
 * @date 2020-09-02 8:56
 * @since 2020-0630
 */
@Component
public class SmsComponent {

    public SmsComponent(){
        System.out.println("SmsComponent 构造函数 is called !");
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    public void send(String url, Map<String,String> para){

    }

    @PreDestroy
    public void destory(){
        System.out.println("destory");
    }

}
