package com.kq.jdbc1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * InsertDataApplication
 *
 * @author kq
 * @date 2019-10-11
 */

@SpringBootApplication
public class Jdbc1Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Jdbc1Application.class, args);
    }

}
