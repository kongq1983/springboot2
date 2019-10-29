package com.kq.activemq.producer.scheduled;

import com.kq.activemq.producer.ActivemqProducerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SendMailScheduledTest
 *
 * @author kq
 * @date 2019-08-06
 */

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ActivemqProducerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootTest(classes = ActivemqProducerApplication.class)
public class SendMailScheduledTest {

    @Autowired
    private SendMailScheduled sendMailScheduled;


    @Test
    public void testScheduled() {
        for(int i=0;i<3;i++) {
            sendMailScheduled.send();
        }

    }

}
