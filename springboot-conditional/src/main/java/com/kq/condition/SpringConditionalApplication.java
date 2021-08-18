package com.kq.condition;

import com.kq.condition.entity.MyBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
public class SpringConditionalApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringConditionalApplication.class, args);

//        MyBean bean = context.getBean(MyBean.class);
//        System.out.println("bean="+bean);


    }

}
