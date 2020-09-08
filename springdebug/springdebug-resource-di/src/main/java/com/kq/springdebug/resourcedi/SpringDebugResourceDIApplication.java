package com.kq.springdebug.resourcedi;


import com.kq.entity.Account;
import com.kq.springdebug.resourcedi.config.MessageComponent;
import com.kq.springdebug.resourcedi.config.MyConfig;
import com.kq.springdebug.resourcedi.config.SmsComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.kq.springdebug")
public class SpringDebugResourceDIApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringDebugResourceDIApplication.class);

        MyConfig myConfig = context.getBean(MyConfig.class);


        MessageComponent messageComponent = context.getBean(MessageComponent.class);
        System.out.println("smsComponent="+messageComponent.getSmsComponent1());

        SmsComponent smsComponent = context.getBean(SmsComponent.class);
        System.out.println("smsComponent="+smsComponent);



    }

}
