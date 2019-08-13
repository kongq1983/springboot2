package com.kq.springmvc;

import com.kq.springmvc.config.MyConfiguration;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * TestValue
 *
 * @author kq
 * @date 2019-08-13
 */
public class TestValue extends BaseTest{

    @Value("${my.port}")
    private String myPort;

    @Value("${server.port}")
    private String serverPort;


    @Value("${server.address}")
    private String serverAddress;

    @Value("${spring.application.name}")
    private String applicationName;


    /**
     * 配置不存在 用:
     */
    @Value("${my.server:localhost}")
    private String myServer;


    @Autowired
    MyConfiguration myConfiguration;


    @Test
    public void testValue(){
        System.out.println("myPort="+myPort);
        System.out.println("serverPort="+serverPort);
        System.out.println("applicationName="+applicationName);
        System.out.println("serverAddress="+serverAddress);
        System.out.println("myServer="+myServer);
        System.out.println("myConfiguration="+myConfiguration);
    }


}
