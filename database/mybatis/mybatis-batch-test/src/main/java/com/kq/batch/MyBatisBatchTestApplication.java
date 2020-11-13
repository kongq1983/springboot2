package com.kq.batch;

import com.kq.batch.service.EmployeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyBatisBatchTestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MyBatisBatchTestApplication.class, args);

        EmployeService employeService = context.getBean(EmployeService.class);
        employeService.insertTen();

        System.out.println("=======================================================================================");

    }

}
