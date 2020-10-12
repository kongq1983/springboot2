package com.kq.aop;

import com.kq.aop.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author kq
 * @date 2020-10-10 10:46
 * @since 2020-0630
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.kq.aop")
public class SpringSimpleAopApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringSimpleAopApplication.class);
        PersonService personService = context.getBean(PersonService.class);
        personService.addPerson("king");
    }
}
