package com.kq.es;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * ElasticSearchApplication
 *
 * @author kq
 * @date 2019-10-18
 */
@Slf4j
@SpringBootApplication
public class ElasticSearchApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ElasticSearchApplication.class, args);

        String[] beanNames = context.getBeanDefinitionNames();

        for(String beanName : beanNames) {
            log.info("load beanName ={}",beanName);
        }

        log.info("load beanNames size ={}",context.getBeanDefinitionCount());

    }

}
