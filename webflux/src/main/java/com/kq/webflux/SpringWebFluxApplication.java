package com.kq.webflux;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * SpringWebFluxApplication
 * @author kq
 * @date 2019-09-17
 */

@Slf4j
@SpringBootApplication
public class SpringWebFluxApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringWebFluxApplication.class, args);

        String[] beanNames = context.getBeanDefinitionNames();

        for(String beanName : beanNames) {
            log.info("load beanName ={}",beanName);
        }

        log.info("load beanNames size ={}",context.getBeanDefinitionCount());

    }


}
