package com.kq.springdebug.factorybean;


import com.kq.entity.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.kq.springdebug")
public class SpringDebugFactoryBeanApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringDebugFactoryBeanApplication.class);

        MyFactoryBean factoryBean = context.getBean(MyFactoryBean.class);
        System.out.println("factoryBean="+factoryBean);


        Account account = context.getBean(Account.class);
        System.out.println("account="+account);


    }

}
