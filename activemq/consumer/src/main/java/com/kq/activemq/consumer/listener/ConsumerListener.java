package com.kq.activemq.consumer.listener;

import com.kq.constants.DestinationConstants;
import com.kq.dto.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * ConsumerListener
 *
 * @author kq
 * @date 2019-08-06
 */
@Component
public class ConsumerListener {

    protected Logger logger = LoggerFactory.getLogger(ConsumerListener.class);

    @JmsListener(destination = DestinationConstants.TOPIC.MAIL_TOPIC_NAME)
    public void receiveEmail(Email email) {
        logger.info("received com.mailbox.topic : {} ",email);
    }


    @JmsListener(destination = DestinationConstants.TOPIC.STRING_TOPIC_NAME)
    public void receiveString(String email) {
        logger.info("received com.string.topic : {} ",email);
    }


    @JmsListener(destination = DestinationConstants.QUEUE.STRING_QUEUE_NAME,containerFactory = "myJmsContainerFactory")
    public void receiveQueueString(String msg) {
        logger.info("received com.string.queue : {} ",msg);
    }


    @JmsListener(destination = DestinationConstants.QUEUE.JSON_QUEUE_NAME)
    public void receiveQueueEmail(Email email) {
        logger.info("received com.json.queue : {} ",email);
    }


}
