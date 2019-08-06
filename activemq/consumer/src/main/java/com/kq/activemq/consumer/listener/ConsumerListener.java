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
    public void receive(Email email) {
        logger.info("received email : {} ",email);
    }


}
