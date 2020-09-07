package com.kq.spring.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@ComponentScan("com.kq.spring.listener")
@Configuration
public class ApplicationListenerDemo {


    public static void main(String[] args) throws Exception{

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationListenerDemo.class);

        EmailEvent event = new EmailEvent("notify","listener@163.com","this is application listener demo.");
        //主动触发该事件
        context.publishEvent(event);


        TimeUnit.MINUTES.sleep(30);


    }


}
