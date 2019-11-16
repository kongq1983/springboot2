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

import static com.kq.constants.DestinationConstants.QUEUE.*;

/**
 * SendMail
 *
 * @author kq
 * @date 2019-08-06
 */

@Component
public class SendMailScheduled {Thread.

    protected Logger logger = LoggerFactory.getLogger(SendMailScheduled.class);

    @Resource(name="jmsTopicTemplate")
    private JmsTemplate jmsTopicTemplate;

    @Resource(name="queueJmsTemplate")
    private JmsTemplate queueJmsTemplate;

    @Resource(name="queueJsonJmsTemplate")
    private JmsTemplate queueJsonJmsTemplate;


    @Autowired
    @Qualifier("jmsStringTopicTemplate")
    private JmsTemplate jmsStringTopicTemplate;

    private AtomicInteger ato = new AtomicInteger();



//    @Scheduled(cron="0 */5 * * * ?")   //每5分钟执行一次
    @Scheduled(cron="0 */1 * * * ?")   //每1分钟执行一次
//    @Scheduled(fixedDelay=30*1000)   //每30s执行一次
    public void send(){

        int num = ato.getAndIncrement();
        logger.info("index={} , start run send mail. ",num);

        jmsTopicTemplate.convertAndSend(DestinationConstants.TOPIC.MAIL_TOPIC_NAME, new Email("king"+num+"@topic.com", "topic Hello"+num));
        queueJsonJmsTemplate.convertAndSend(DestinationConstants.QUEUE.JSON_QUEUE_NAME, new Email("king"+num+"@queue.com", "queue Hello"+num));
        jmsStringTopicTemplate.convertAndSend(DestinationConstants.TOPIC.STRING_TOPIC_NAME, "welcome to you ! topic index="+num);

        queueJmsTemplate.convertAndSend(STRING_QUEUE_NAME,"welcome to you ! queue = "+num);
    }


}
