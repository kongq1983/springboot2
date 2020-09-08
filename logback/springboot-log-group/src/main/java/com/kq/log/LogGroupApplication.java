package com.kq.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author kq
 * @date 2020-09-08 16:15
 * @since 2020-0630
 */

@EnableScheduling
@SpringBootApplication
public class LogGroupApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LogGroupApplication.class, args);

    }

}
