package com.kq.beandefinition.register;

import com.kq.entity.Inventory;
import com.kq.entity.School;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author kq
 * @date 2020-09-30 8:57
 * @since 2020-0630
 */
@Configuration
@ComponentScan("com.kq.beandefinition.register")
public class SpringBeanDefinitionRegisterApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanDefinitionRegisterApplication.class);
        Inventory i = context.getBean(Inventory.class);
        System.out.println(i);

        School school = (School)context.getBean("school");
        System.out.println("school="+school);

        String[] schoolAlias = context.getAliases("school");
        System.out.println("schoolAlias="+ StringUtils.join(schoolAlias,","));
//
//
//        School firstSchool = (School)context.getBean("firstSchool");
//        System.out.println("firstSchool="+firstSchool);

//        School secondSchool = (School)context.getBean("secondSchool");



//        System.out.println("secondSchool="+secondSchool);

    }

}
