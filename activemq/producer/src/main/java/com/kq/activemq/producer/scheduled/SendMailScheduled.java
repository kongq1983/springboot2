package com.kq.activemq.producer.scheduled;

import com.kq.constants.DestinationConstants;
import com.kq.dto.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * SendMail
 *
 * @author kq
 * @date 2019-08-06
 */

@Component
public class SendMailScheduled {

    protected Logger logger = LoggerFactory.getLogger(SendMailScheduled.class);

    @Resource(name="jmsTopicTemplate")
    private JmsTemplate jmsTopicTemplate;


    @Autowired
    @Qualifier("jmsTopicTemplate")
    private JmsTemplate jmsTopicTemplate1;

    private AtomicInteger ato = new AtomicInteger();



//    @Scheduled(cron="0 */5 * * * ?")   //每5分钟执行一次
    @Scheduled(cron="0 */1 * * * ?")   //每1分钟执行一次
//    @Scheduled(fixedDelay=30*1000)   //每30s执行一次
    public void send(){

        int num = ato.getAndIncrement();
        logger.info("index={} , start run send mail. ",num);

        jmsTopicTemplate.convertAndSend(DestinationConstants.TOPIC.MAIL_TOPIC_NAME, new Email("info-1@example.com", "Hello"+num));
        jmsTopicTemplate1.convertAndSend(DestinationConstants.TOPIC.MAIL_TOPIC_NAME, new Email("info-2@example.com", "Hello"+num));
    }


}
