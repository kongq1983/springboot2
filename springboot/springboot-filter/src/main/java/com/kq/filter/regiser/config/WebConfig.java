package com.kq.filter.regiser.config;

import com.kq.filter.regiser.filter.Test1Filter;
import com.kq.filter.regiser.filter.Test2Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;

/**
 * @author kq
 * @date 2021-05-17 9:27
 * @since 2020-0630
 */
@Configuration
public class WebConfig {

    @Bean
    public Filter test1Filter() {
        return new Test1Filter();
    }

    @Bean
    public Filter test2Filter() {
        return new Test2Filter();
    }

    /**
     * 注册filter，统一处理api开头的请求
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean test1FilterRegistrationBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // DelegatingFilterProxy把servlet 容器中的filter同spring容器中的bean关联起来
        registration.setFilter(new DelegatingFilterProxy(test1Filter()));
//        registration.setFilter(new DelegatingFilterProxy("tokenAuthFilter"));
        registration.addUrlPatterns("/api/*");
        registration.setName("test1Filter");
        registration.setOrder(2);
        return registration;
    }

    @Bean
    public FilterRegistrationBean test2FilterRegistrationBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // DelegatingFilterProxy把servlet 容器中的filter同spring容器中的bean关联起来
        registration.setFilter(new DelegatingFilterProxy(test2Filter()));
        registration.addUrlPatterns("/api/*");
        registration.setName("test2Filter");
        registration.setOrder(1);
        return registration;
    }

}
