package com.kq.condition.config;

import com.kq.condition.entity.MyBean;
import com.kq.condition.entity.MyData;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 你可以简单粗暴的记住结论：@AutoConfigureBefore、@AutoConfigureAfter、@AutoConfigureOrder这三个注解只能作用于自动配置类，而不能是自定义的@Configuration配置类
 * @author kq
 * @date 2021-04-01 17:52
 * @since 2020-0630
 */
@Configuration
// LastConfiguration之前 执行
@AutoConfigureBefore(LastConfiguration.class)
// 在FirstConfiguration之后 执行
@AutoConfigureAfter(FirstConfiguration.class)
public class MyConfiguration {


//    @ConditionalOnProperty(value = "my.bean.load",matchIfMissing=true)
//    @ConditionalOnProperty(prefix = "my",value = "bean.load")
    @ConditionalOnProperty(prefix = "my",name = "bean.load")
    @Bean
    public MyBean getMyBean(){
        MyBean bean = new MyBean();
        bean.setId(1L);
        bean.setName("hello");

        return bean;

    }


    @Bean
    public MyData getMyData2(){
        System.out.println("MyConfiguration getMyData ");
        return new MyData();

    }


}
