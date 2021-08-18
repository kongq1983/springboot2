package com.kq.acutator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author kq
 * @date 2021-01-15 14:06
 * @since 2020-0630
 */
@SpringBootApplication
public class AcutatorApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AcutatorApplication.class, args);
    }
}
