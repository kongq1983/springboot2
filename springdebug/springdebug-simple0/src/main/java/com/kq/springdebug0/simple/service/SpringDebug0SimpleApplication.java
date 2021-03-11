package com.kq.springdebug0.simple.service;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.kq.springdebug.simple")
@ComponentScan
public class SpringDebug0SimpleApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringDebug0SimpleApplication.class);
//        ApplicationContext context = new AnnotationConfigApplicationContext(Config1.class,SpringDebugSimpleApplication.class);

        ICircleA circleA = context.getBean(ICircleA.class);
        System.out.println("circleA="+circleA);
        circleA.showB();

        ICircleB circleB = context.getBean(ICircleB.class);
        System.out.println("circleB="+circleB);
        circleB.showA();

    }

}
