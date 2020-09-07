package com.kq.spring.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CommonNotifier implements ApplicationListener {

    public CommonNotifier() {
        System.out.println("EmailNotifier init");
    }

    public void onApplicationEvent(ApplicationEvent event) {

        if (event instanceof EmailEvent) {
            System.out.println("CommonNotifier 收到EmailEvent事件:"+event);
            EmailEvent emailEvent = (EmailEvent) event;
            System.out.println("邮件地址：" + emailEvent.getAddress());
            System.out.println("邮件内容：" + emailEvent.getText());
        } else {
            System.out.println("CommonNotifier 容器本身事件：" + event);
        }

    }

}

