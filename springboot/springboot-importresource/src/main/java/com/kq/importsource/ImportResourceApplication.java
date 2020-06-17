package com.kq.importsource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@PropertySource(value = {"classpath:my.properties"})
@EnableScheduling
@SpringBootApplication
public class ImportResourceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ImportResourceApplication.class, args);

    }

}
