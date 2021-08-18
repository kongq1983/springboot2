package com.kq.condition.config;

import com.kq.condition.entity.MyBean;
import com.kq.condition.entity.MyData;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kq
 * @date 2021-04-01 19:09
 * @since 2020-0630
 */
@Configuration
@AutoConfigureAfter(MyConfiguration.class)
public class LastConfiguration {

    @Bean
    public MyData getMyData3(){
        System.out.println("LastConfiguration getMyData ");
        return new MyData();

    }

}
