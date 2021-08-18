package com.kq.logback.config;

import com.kq.logback.interceptor.TraceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author kq
 * @date 2021-07-26 9:38
 * @since 2020-0630
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public TraceInterceptor initTraceInterceptor() {
        return new TraceInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(initTraceInterceptor()).addPathPatterns("/**");
    }

}
