package com.kq.springdebug.factorybean.config;

/**
 * @author kq
 * @date 2020-09-02 17:41
 * @since 2020-0630
 */
public class MessageComponent {

    private SmsComponent smsComponent;

    public SmsComponent getSmsComponent() {
        return smsComponent;
    }

    public void setSmsComponent(SmsComponent smsComponent) {
        this.smsComponent = smsComponent;
    }

    @Override
    public String toString() {
        return "MessageComponent{" +
                "smsComponent=" + smsComponent +
                '}';
    }
}
