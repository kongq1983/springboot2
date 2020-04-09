package com.kq.springdebug.factorybean.config;

import com.kq.springdebug.factorybean.MyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MyConfig {

    @Bean
    public MyFactoryBean getFactoryBean() {
        return new MyFactoryBean();
    }

}
