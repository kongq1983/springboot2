package com.kq.httpclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

/**
 * BaseController
 *
 * @author kq
 * @date 2019-11-27
 */
public class BaseController {

    @Autowired
    protected RestTemplate restTemplate;

    @Value("${server.helloworld-url}")
    protected String helloWorldUrl;

    @Value("${server.helloworld1-url}")
    protected String helloWorldUrl1;

    @Value("${server.helloworld2-url}")
    protected String helloWorldUrl2;

    @Value("${server.helloworld3-url}")
    protected String helloWorldUrl3;

    @Value("${server.helloworld4-url}")
    protected String helloWorldUrl4;

    @Value("${server.helloworld5-url}")
    protected String helloWorldUrl5;

    @Value("${server.helloworldStart-url}")
    protected String helloWorldUrlStart;

    @Value("${server.helloworldDataBase-url}")
    protected String helloworldDataBase;

}
