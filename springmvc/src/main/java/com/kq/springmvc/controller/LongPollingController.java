package com.kq.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.concurrent.*;
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

    ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(5000);

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(600,600,5,TimeUnit.SECONDS,arrayBlockingQueue);

    public LongPollingController(){
        threadPoolExecutor.prestartAllCoreThreads();
        log.info("LongPollingController构造函数");
    }


    /**
     * http://localhost:10001/longpolling/view/100
     * @param id
     * @param request
     * @param response
     */
    @RequestMapping(value="/view/{id}",method = RequestMethod.GET)
    public void getData(@PathVariable("id") String id, HttpServletRequest request,HttpServletResponse response) {


        printHeaders(request);
        log.debug("view id={}",id);

        this.addRunnable(id,request,response);

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


    public void addRunnable(String id , HttpServletRequest request,HttpServletResponse response){

        long sign = atomicLong.incrementAndGet();
        String data = id+":"+sign+"\n";
        System.out.println(LocalDateTime.now()+":"+data);
        int timeout = 1;


        int sync = NumberUtils.toInt(request.getParameter("sync"),0);

        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String random = request.getParameter("random");
        String increment = request.getParameter("increment");
        int version = NumberUtils.toInt(request.getParameter("version"),0);

        log.debug("receive data , random={} account={},password={}, username={} ,version={} incremen={}",random,account,password,username,version,increment);

        log.info("sync="+sync);
        if(sync>0) {
            try {
                log.info("{}------------------------start同步",sign);
//                TimeUnit.SECONDS.sleep(timeout);
//                TimeUnit.MILLISECONDS.sleep(timeout*300);
                log.info("{}------------------------end同步",sign);
                response.getWriter().write("sync:"+data);
                response.getWriter().flush();
            }catch (Exception e){
                e.printStackTrace();
            }
            return;
        }

        request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);

        final AsyncContext asyncContext = request.startAsync();
        // AsyncContext.setTimeout() is incorrect, Control by oneself
//        asyncContext.setTimeout(5L);
        asyncContext.setTimeout(0L);

        HttpServletResponse ayncResponse = (HttpServletResponse) asyncContext.getResponse();

        Runnable runnable = ()->{
            try {
                log.info("runnable is execute!");
//                String data = id+":"+atomicLong.incrementAndGet()+"isClose="+response.getWriter()+"\n";

                log.info("{}------------------------start异步",sign);

                TimeUnit.SECONDS.sleep(timeout);
                log.info("{}------------------------end异步",sign);

//                ayncResponse.setHeader("Pragma", "no-cache");
//                ayncResponse.setDateHeader("Expires", 0);
//                ayncResponse.setHeader("Cache-Control", "no-cache,no-store");
//                ayncResponse.setStatus(HttpServletResponse.SC_OK);
                ayncResponse.getWriter().write("async:"+data);
                ayncResponse.getWriter().flush();

            }catch (Exception e){
                System.out.println("-----------------------------------");
                e.printStackTrace();
            } finally {
                asyncContext.complete();
            }
        };

//        runnable.run();
//        threadPoolExecutor.scheduleAtFixedRate(runnable,1,5, TimeUnit.SECONDS);
//        threadPoolExecutor.schedule(runnable,3,TimeUnit.SECONDS);
        threadPoolExecutor.execute(runnable);

    }


}
