package com.kq.condition.config;

import com.kq.condition.entity.MyBean;
import com.kq.condition.entity.MyData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kq
 * @date 2021-04-01 19:08
 * @since 2020-0630
 */
@Configuration
public class FirstConfiguration {

    @Bean
    public MyData getMyData1(){
        System.out.println("FirstConfiguration getMyData ");
        return new MyData();

    }


}
