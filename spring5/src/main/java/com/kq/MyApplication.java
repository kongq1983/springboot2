package com.kq;

import com.kq.config.MyConfiguration;
import com.kq.dto.Employee;
import com.kq.entity.School;
import com.kq.service.ICircleA;
import com.kq.service.ICircleB;
import com.kq.service.impl.CircleB;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// https://blog.csdn.net/nuomizhende45/article/details/81158383
public class MyApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);

//        School e = context.getBean(School.class);
//        if(e!=null)
//        System.out.println(e.getId());

        ICircleA circleA = context.getBean(ICircleA.class);
        System.out.println("circleA="+circleA);
        circleA.showB();

        ICircleB circleB = context.getBean(ICircleB.class);
        System.out.println("circleB="+circleB);
        circleB.showA();

    }

}
