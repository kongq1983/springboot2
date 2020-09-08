package com.kq.springdebug.resourcedi.config;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author kq
 * @date 2020-09-02 17:41
 * @since 2020-0630
 */
//@Component
public class MessageComponent {

    @Resource(name="abcd")
//    @Resource()
    private SmsComponent smsComponent1;

    public SmsComponent getSmsComponent1() {
        return smsComponent1;
    }

    public void setSmsComponent1(SmsComponent smsComponent1) {
        this.smsComponent1 = smsComponent1;
    }

    @Override
    public String toString() {
        return "MessageComponent{" +
                "smsComponent=" + smsComponent1 +
                '}';
    }
}
