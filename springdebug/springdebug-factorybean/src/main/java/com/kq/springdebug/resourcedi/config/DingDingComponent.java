package com.kq.springdebug.resourcedi.config;

/**
 * @author kq
 * @date 2020-09-03 10:28
 * @since 2020-0630
 */
public class DingDingComponent {

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
