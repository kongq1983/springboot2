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

        String[] circleAs = context.getBeanNamesForType(ICircleA.class);
        for(String c : circleAs) {
            System.out.println("**************** circleA="+c);
        }

//        ICircleA circleA = context.getBean(ICircleA.class);
        ICircleA circleA = (ICircleA)context.getBean("circleA");
        System.out.println("circleA="+circleA);
        circleA.showB();

        ICircleB circleB = context.getBean(ICircleB.class);
        System.out.println("circleB="+circleB);
        circleB.showA();

        ScopeA scopeA = context.getBean(ScopeA.class);
        System.out.println("======== scopeA="+scopeA);

        scopeA = context.getBean(ScopeA.class);
        System.out.println("======== scopeA="+scopeA);

//        context.isSingleton();

        String[] beanNames = context.getBeanDefinitionNames();

        for(String beanName : beanNames) {
            System.out.println("beanName="+beanName);
        }


//        ScopeOther scopeOther = context.getBean(ScopeOther.class);
//        System.out.println("======== scopeOther="+scopeOther);




    }

}
