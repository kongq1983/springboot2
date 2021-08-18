package com.kq.springmvc.controller;

import com.kq.dto.DtoResult;
import com.kq.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author kq
 * @date 2021-04-21 15:36
 * @since 2020-0630
 */
@RestController
@Slf4j
public class SlowTestController {

    private AtomicLong automatLong = new AtomicLong();


    @RequestMapping(value="/slow/get",method = RequestMethod.GET)
    public DtoResult get() {

        automatLong.incrementAndGet();

        log.info("get index={} ",automatLong.get());

        DtoResult result = new DtoResult();

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<1000;i++) {
            stringBuilder.append(i);
        }
        result.setResult("GET:"+stringBuilder.toString());
        return result;
    }



    @RequestMapping(value="/slow/post",method = RequestMethod.POST)
    public DtoResult post(@RequestBody Employee e) {

        automatLong.incrementAndGet();

        log.info("post index={} add 接收参数={}",automatLong.get(),e);

        DtoResult result = new DtoResult();

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<1000;i++) {
            stringBuilder.append(i);
        }
        result.setResult("POST:"+stringBuilder.toString());
        return result;
    }


}
