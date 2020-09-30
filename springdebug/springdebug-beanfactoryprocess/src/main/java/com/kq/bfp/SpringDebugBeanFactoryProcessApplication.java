package com.kq.bfp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author kq
 * @date 2020-09-29 10:01
 * @since 2020-0630
 */
@Configuration
@ComponentScan("com.kq.bfp")
public class SpringDebugBeanFactoryProcessApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringDebugBeanFactoryProcessApplication.class);
        System.out.println(context);
    }

}
