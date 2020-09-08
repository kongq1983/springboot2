package com.kq.springdebug.resourcedi.config;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author kq
 * @date 2020-09-02 17:41
 * @since 2020-0630
 */
@Component
public class DingDingComponent {

    @Resource()
    private SmsComponent smsComponent;

    public SmsComponent getSmsComponent() {
        return smsComponent;
    }

    public void setSmsComponent(SmsComponent smsComponent) {
        this.smsComponent = smsComponent;
    }

    @Override
    public String toString() {
        return "DingDingComponent{" +
                "smsComponent=" + smsComponent +
                '}';
    }
}
