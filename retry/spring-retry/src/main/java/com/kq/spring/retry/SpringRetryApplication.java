package com.kq.spring.retry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

/**
 * SpringRetryApplication
 *
 * @author kq
 * @date 2023-07-31 21:53
 * @since 1.0.0
 */
@EnableRetry
@SpringBootApplication
public class SpringRetryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRetryApplication.class, args);
    }

}
