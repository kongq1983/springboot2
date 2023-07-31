package com.kq.spring.retry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * RetryConfiguration
 *
 * @author kq
 * @date 2023-07-31 22:29
 * @since 1.0.0
 */
@Configuration
public class RetryConfiguration {

    @Bean
    public RestTemplate getRestTemplate() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectTimeout(3000);//设置超时时间
        httpRequestFactory.setReadTimeout(3000);

        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);

        return restTemplate;
    }



//    @Bean
//    public RestTemplate getRestTemplate() {
//
//        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        httpRequestFactory.setConnectTimeout(5000);//设置超时时间
//
//        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
//
//        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//        requestFactory.setConnectTimeout(5000);//设置超时时间
//        requestFactory.setReadTimeout(5000);//设置读取超时时间
//
//        restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(requestFactory));
//
//        restTemplate.getInterceptors().add(new RetryInterceptor(3));//设置最大重试次数
//
//        return restTemplate;
//
//    }

}
