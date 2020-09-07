package com.kq.springdebug.simple;


import com.kq.springdebug.simple.component.InitAndDestory;
import com.kq.springdebug.simple.service.ICircleA;
import com.kq.springdebug.simple.service.ICircleB;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.kq.springdebug.simple")
public class SpringDebugSimpleApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringDebugSimpleApplication.class);

        ICircleA circleA = context.getBean(ICircleA.class);
        System.out.println("circleA="+circleA);
        circleA.showB();

        ICircleB circleB = context.getBean(ICircleB.class);
        System.out.println("circleB="+circleB);
        circleB.showA();

        InitAndDestory initAndDestory = context.getBean(InitAndDestory.class);
        System.out.println("initAndDestory="+initAndDestory);

//        String[] beanNames = context.getBeanDefinitionNames();
//
//        for(String beanName : beanNames) {
//            System.out.println("load beanName ="+beanName);
//        }
//
//        System.out.println("load beanNames size = "+context.getBeanDefinitionCount());


    }

}
