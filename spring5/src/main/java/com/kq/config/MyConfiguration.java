package com.kq.config;

import com.kq.dto.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public Employee getEmployee(){
        Employee e = new Employee();
        e.setId(100L);
        e.setName("hello");
        return e;
    }

}
