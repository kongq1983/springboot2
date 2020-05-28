package com.kq.spring.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class EmailNotifier implements ApplicationListener<EmailEvent> {

    public EmailNotifier() {
        System.out.println("EmailNotifier init");
    }

    public void onApplicationEvent(EmailEvent event) {

        System.out.println("EmailNotifier收到EmailEvent事件:" + event);
    }

}