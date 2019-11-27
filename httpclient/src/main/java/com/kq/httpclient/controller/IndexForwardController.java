package com.kq.httpclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndexForwardController
 *
 * @author kq
 * @date 2019-11-27
 */
@RestController
@Slf4j
public class IndexForwardController extends BaseController{


    @RequestMapping("/helloworld1")
    public String index() {

        log.info("enter into IndexForwardController.helloworld1 :{}", System.currentTimeMillis());

//        String result = this.restTemplate.getForObject(helloWorldUrl,String.class);
        String result = this.restTemplate.getForObject(helloworldDataBase,String.class);
        return result;

    }

    @RequestMapping("/helloworld2")
    public String helloworld2() {

        log.info("enter into IndexForwardController.helloworld2 :{}", System.currentTimeMillis());

        String result = this.restTemplate.getForObject(this.helloWorldUrl1,String.class);
        return result;

    }

    @RequestMapping("/helloworld3")
    public String helloworld3() {

        log.info("enter into IndexForwardController.helloworld3 :{}", System.currentTimeMillis());

        String result = this.restTemplate.getForObject(this.helloWorldUrl2,String.class);
        return result;

    }

    @RequestMapping("/helloworld4")
    public String helloworld4() {

        log.info("enter into IndexForwardController.helloworld4 :{}", System.currentTimeMillis());

        String result = this.restTemplate.getForObject(this.helloWorldUrl3,String.class);
        return result;

    }

    @RequestMapping("/helloworld5")
    public String helloworld5() {

        log.info("enter into IndexForwardController.helloworld5 :{}", System.currentTimeMillis());

        String result = this.restTemplate.getForObject(this.helloWorldUrl4,String.class);
        return result;

    }


}
