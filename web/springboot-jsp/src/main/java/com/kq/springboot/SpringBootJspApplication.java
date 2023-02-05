package com.kq.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * SpringBootJspApplication
 *
 * @author kq
 * @date 2023-02-05 12:44
 * @since 1.0.0
 */
@SpringBootApplication
public class SpringBootJspApplication {

    protected static Logger logger = LoggerFactory.getLogger(SpringBootJspApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootJspApplication.class, args);

//        String[] beanNames = context.getBeanDefinitionNames();
//
//        for(String beanName : beanNames) {
//            logger.info("load beanName ={}",beanName);
//        }
//
//        logger.info("load beanNames size ={}",context.getBeanDefinitionCount());

    }

}
