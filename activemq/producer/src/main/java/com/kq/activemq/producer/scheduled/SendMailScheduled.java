package com.kq.activemq.producer.scheduled;

import com.kq.constants.DestinationConstants;
import com.kq.dto.Email;
import org.springframework.jms.core.JmsTemplate;

import javax.annotation.Resource;

/**
 * SendMail
 *
 * @author kq
 * @date 2019-08-06
 */
public class SendMailScheduled {

    @Resource(name="jmsTopicTemplate")
    private JmsTemplate jmsTopicTemplate;



    public void send(){
        jmsTopicTemplate.convertAndSend(DestinationConstants.TOPIC.MAIL_TOPIC_NAME, new Email("info@example.com", "Hello"));
    }


}
