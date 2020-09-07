package com.kq.importsource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyConfiguration {

    @Bean
    public List<String> getDatas(){
        List<String> list = new ArrayList();
        list.add("one");

        return list;
    }

}
