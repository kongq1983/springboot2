package com.kq.httpclient;


import com.kq.httpclient.component.ResttemplateComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class HttpClientApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(HttpClientApplication.class, args);

//        ResttemplateComponent rest =  context.getBean(ResttemplateComponent.class);
//
//        rest.start();


    }


}
