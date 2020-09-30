package com.kq.beandefinition.register;

import com.kq.entity.Inventory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author kq
 * @date 2020-09-30 8:57
 * @since 2020-0630
 */
@Configuration
@ComponentScan("com.kq.beandefinition.register")
public class SpringBeanDefinitionRegisterApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanDefinitionRegisterApplication.class);
        Inventory i = context.getBean(Inventory.class);
        System.out.println(i);

    }

}
