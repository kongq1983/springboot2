package com.kq.springdebug;


import com.kq.springdebug.simple2.service.ICircleA;
import com.kq.springdebug.simple2.service.ICircleB;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.kq.springdebug.simple")
@ComponentScan
public class SpringDebug2SimpleApplication {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringDebug2SimpleApplication.class);
//        ApplicationContext context = new AnnotationConfigApplicationContext(Config1.class,SpringDebugSimpleApplication.class);


//        ICircleA circleA = context.getBean(ICircleA.class);
        ICircleA circleA = (ICircleA)context.getBean("circleA");
        System.out.println("circleA="+circleA);
        circleA.showB();

        ICircleB circleB = context.getBean(ICircleB.class);
        System.out.println("circleB="+circleB);
        circleB.showA();

//        ScopeOther scopeOther = context.getBean(ScopeOther.class);
//        System.out.println("======== scopeOther="+scopeOther);




    }

}
