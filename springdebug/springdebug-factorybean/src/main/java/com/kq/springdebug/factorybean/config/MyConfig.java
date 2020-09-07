package com.kq.springdebug.factorybean.config;

import com.kq.springdebug.factorybean.MyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public MyFactoryBean getFactoryBean() {
        return new MyFactoryBean();
    }

    @Bean
    public MessageComponent getMessageComponent(){
        MessageComponent messageComponent = new MessageComponent();
        messageComponent.setSmsComponent(getSmsComponent());
        return messageComponent;
    }

    @Bean
    public WeixinComponent getWeixinComponent(SmsComponent smsComponent1){
        WeixinComponent messageComponent = new WeixinComponent();
        messageComponent.setSmsComponent(smsComponent1);
        return messageComponent;
    }


    @Bean
    public DingDingComponent getDingDingComponent(SmsComponent smsComponent1){
        DingDingComponent messageComponent = new DingDingComponent();
        messageComponent.setSmsComponent(smsComponent1);
        return messageComponent;
    }

//    @Bean
//    public MessageComponent getMessageComponent(SmsComponent smsComponent){
//        MessageComponent messageComponent = new MessageComponent();
//        messageComponent.setSmsComponent(smsComponent);
////        messageComponent.setSmsComponent(getSmsComponent());
//        return messageComponent;
//    }

    @Bean
    public SmsComponent getSmsComponent(){
        SmsComponent c = new SmsComponent();
        return c;
    }



}
