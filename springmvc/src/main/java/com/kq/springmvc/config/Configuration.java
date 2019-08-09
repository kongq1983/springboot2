package com.kq.springmvc.config;

import com.kq.springmvc.interceptor.RestTemplateLoggerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * Configuration
 *
 * @author kq
 * @date 2019-08-09
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

//        restTemplate.setInterceptors(Collections.singletonList(loggingClientHttpRequestInterceptor));

        restTemplate.getInterceptors().add(new RestTemplateLoggerInterceptor());

        return restTemplate;
    }


}
