package com.kq.resttemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ResttemplateApplication {

    protected static Logger logger = LoggerFactory.getLogger(ResttemplateApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ResttemplateApplication.class, args);

        String[] beanNames = context.getBeanDefinitionNames();

        for(String beanName : beanNames) {
            logger.info("load beanName ={}",beanName);
        }

        logger.info("load beanNames size ={}",context.getBeanDefinitionCount());
    }

}
