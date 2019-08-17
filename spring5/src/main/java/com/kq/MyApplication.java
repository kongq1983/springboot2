package com.kq;

import com.kq.config.MyConfiguration;
import com.kq.dto.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);

        Employee e = context.getBean(Employee.class);
        System.out.println(e.getId());

    }

}
