package com.kq.springdebug.resourcedi;


import com.kq.entity.Account;
import com.kq.springdebug.resourcedi.config.MessageComponent;
import com.kq.springdebug.resourcedi.config.MyConfig;
import com.kq.springdebug.resourcedi.config.SmsComponent;
import com.kq.springdebug.resourcedi.config.WeixinComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.kq.springdebug")
public class SpringDebugFactoryBeanApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringDebugFactoryBeanApplication.class);

        MyFactoryBean factoryBean = context.getBean(MyFactoryBean.class);
        System.out.println("factoryBean="+factoryBean);


        Account account = context.getBean(Account.class);
        System.out.println("account="+account);

        MyConfig myConfig = context.getBean(MyConfig.class);


        MessageComponent messageComponent = context.getBean(MessageComponent.class);
        System.out.println("smsComponent="+messageComponent.getSmsComponent());
        WeixinComponent weixinComponent = context.getBean(WeixinComponent.class);
        System.out.println("WeixinComponent="+weixinComponent.getSmsComponent());
        SmsComponent smsComponent1 = myConfig.getSmsComponent();
        System.out.println("myConfig.getSmsComponent="+smsComponent1);
        SmsComponent smsComponent = context.getBean(SmsComponent.class);
        System.out.println("smsComponent="+smsComponent);





    }

}
