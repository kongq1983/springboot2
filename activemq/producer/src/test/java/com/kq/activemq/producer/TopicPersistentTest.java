package com.kq.activemq.producer;

import com.kq.activemq.producer.scheduled.BaseTest;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;
import java.util.Random;

/**
 * TopicPersistentTest
 *
 * @author kq
 * @date 2019-11-04
 */
public class TopicPersistentTest {



    @Test
    public void testDemo() throws Exception{

        Random r = new Random();

        ConnectionFactory connectionFactory = new
                ActiveMQConnectionFactory(BaseTest.brokeUrl);
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Topic destination = session.createTopic("origin.persistence.topic");
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        connection.start();
        TextMessage message = session.createTextMessage(r.nextInt(1000000)+"");
        //通过消息生产者发出消息
        producer.send(message);
        session.commit();
        session.close();
        connection.close();

        System.out.println("=========================");
    }

}
