package com.kq.activemq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * ActivemqProducerApplication
 *
 * @author kq
 * @date 2019-08-06
 */
@SpringBootApplication
@EnableJms
public class ActivemqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivemqConsumerApplication.class, args);
    }

}
