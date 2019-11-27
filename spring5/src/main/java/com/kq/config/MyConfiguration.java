package com.kq.config;

import com.kq.dto.Employee;
import com.kq.entity.School;
import com.kq.entity.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.kq")
@Configuration
public class MyConfiguration {

//    @Bean
//    public Employee getEmployee(){
//        Employee e = new Employee();
//        e.setId(100L);
//        e.setName("hello");
//        return e;
//    }


//    @Bean
//    public Teacher getTeacher(School school){
//        Teacher e = new Teacher();
//        e.setId(100L);
//        e.setUsername("hello");
//        e.setSchool(school);
//        return e;
//    }
//
//
//    @Bean
//    public School getSchool(Teacher teacher){
//        School e = new School();
//        e.setId(1L);
//        e.setTeacher(teacher);
//        return e;
//    }

}
