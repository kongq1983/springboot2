package com.kq.activemq.producer.scheduled;

import com.kq.activemq.producer.ActivemqProducerApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * BaseTest
 *
 * @author kq
 * @date 2019-11-04
 */
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ActivemqProducerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootTest(classes = ActivemqProducerApplication.class)
public class BaseTest {

    public static final String brokeUrl = "tcp://192.168.5.212:62616";

}
