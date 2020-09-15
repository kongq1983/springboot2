package com.kq.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author kq
 * @date 2020-09-15 17:15
 * @since 2020-0630
 */
@Slf4j
@RestController
@RequestMapping(value="/longpolling")
public class LongPollingController {

    private AtomicLong atomicLong = new AtomicLong(0);

    ScheduledExecutorService threadPoolExecutor = Executors.newSingleThreadScheduledExecutor();


    @RequestMapping(value="/view/{id}",method = RequestMethod.GET)
    public void getData(@PathVariable("id") String id, HttpServletRequest request,HttpServletResponse response) {

        printHeaders(request);
        log.debug("view id={}",id);

        this.addRunnable(id,response);

//        try {
//            TimeUnit.SECONDS.sleep(30);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

    }

    private void printHeaders(HttpServletRequest request) {

        Enumeration<String> set = request.getHeaderNames();

        while (set.hasMoreElements()) {
            String hedaerName = set.nextElement();
            log.debug("header key={},value={}", hedaerName, request.getHeader(hedaerName));
        }

    }


    public void addRunnable(String id , HttpServletResponse response){

        Runnable runnable = ()->{
            try {
//                String data = id+":"+atomicLong.incrementAndGet()+"isClose="+response.getWriter()+"\n";
                String data = id+":"+atomicLong.incrementAndGet()+"\n";
                System.out.println(LocalDateTime.now()+":"+data);
                response.getWriter().write(data);
                response.getWriter().flush();
            }catch (Exception e){
                e.printStackTrace();
            }
        };

        threadPoolExecutor.scheduleAtFixedRate(runnable,1,5, TimeUnit.SECONDS);

    }


}
