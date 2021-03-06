package com.kq.activemq.producer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
import javax.jms.Session;

/**
 * ProducerConfiguration
 *
 * @author kq
 * @date 2019-08-06
 */

@Configuration
public class ProducerConfiguration {

    protected Logger logger = LoggerFactory.getLogger(ProducerConfiguration.class);

    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    @Primary
    @Bean
    public JmsTemplate queueJmsTemplate(ConnectionFactory connectionFactory) {
        PropertyMapper map = PropertyMapper.get();

        logger.info("PropertyMapper={}",map);

        JmsTemplate template = new JmsTemplate(connectionFactory);
//        template.setMessageConverter(this.jacksonJmsMessageConverter());
        // template.setDestinationResolver(destinationResolver);
        template.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);

        logger.info("queueJmsTemplate messageConverter={}",template.getMessageConverter());

        return template;
    }


    @Bean
    public JmsTemplate queueJsonJmsTemplate(ConnectionFactory connectionFactory) {
        PropertyMapper map = PropertyMapper.get();

        logger.info("PropertyMapper={}",map);

        JmsTemplate template = new JmsTemplate(connectionFactory);
        template.setMessageConverter(this.jacksonJmsMessageConverter());
        // template.setDestinationResolver(destinationResolver);
        template.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);

        logger.info("queueJsonJmsTemplate messageConverter={}",template.getMessageConverter());

        return template;
    }

    @Bean(name="jmsTopicTemplate")
    public JmsTemplate topicJmsTemplate(ConnectionFactory connectionFactory) {
        PropertyMapper map = PropertyMapper.get();
        JmsTemplate template = new JmsTemplate(connectionFactory);
        template.setMessageConverter(this.jacksonJmsMessageConverter());
        // topic
        template.setPubSubDomain(true);
        // template.setDestinationResolver(destinationResolver);

        logger.info("topicJmsTemplate messageConverter={}",template.getMessageConverter());

        return template;
    }


    @Bean(name="jmsStringTopicTemplate")
    public JmsTemplate jmsStringTopicTemplate(ConnectionFactory connectionFactory) {
        PropertyMapper map = PropertyMapper.get();
        JmsTemplate template = new JmsTemplate(connectionFactory);
//        template.setMessageConverter(this.jacksonJmsMessageConverter());
        // topic
        template.setPubSubDomain(true);
        // template.setDestinationResolver(destinationResolver);

        logger.info("jmsStringTopicTemplate messageConverter={}",template.getMessageConverter());

        return template;
    }


    @Bean(name="jmsPersistentStringTopicTemplate")
    public JmsTemplate jmsPersistentStringTopicTemplate(ConnectionFactory connectionFactory) {
        PropertyMapper map = PropertyMapper.get();
        JmsTemplate template = new JmsTemplate(connectionFactory);
//        template.setMessageConverter(this.jacksonJmsMessageConverter());
        // topic
        template.setPubSubDomain(true);
        // 设置持久化  最终是deliveryMode
        template.setDeliveryPersistent(true);
        template.setExplicitQosEnabled(true);
        // template.setDestinationResolver(destinationResolver);

        logger.info("jmsStringTopicTemplate messageConverter={}",template.getMessageConverter());

        return template;
    }


}
