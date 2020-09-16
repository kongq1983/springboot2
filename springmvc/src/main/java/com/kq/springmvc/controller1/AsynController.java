package com.kq.springmvc.controller1;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@RestController
@RequestMapping("/asynController")
public class AsynController {

    /**
     * http://localhost:10001/asynController/testAsyn
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/testAsyn",method= RequestMethod.GET)
    public void testAsny(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("start");
        PrintWriter out = response.getWriter();
        AsyncContext asyncContext = request.startAsync();
        asyncContext.setTimeout(5000);
//        asyncContext.addListener(new MyAsyncListener());
        new Thread(new Work(asyncContext,request)).start();
        log.info("before---------------------async execute");
        out.print("-----------async execute-------------------");
        log.info("after---------------------async execute");

        // 注意-要调用complete，否则不会输出浏览器
//        asyncContext.complete();
    }


    class Work implements Runnable{

        private AsyncContext asyncContext;
        private HttpServletRequest request;

        public Work(AsyncContext asyncContext,HttpServletRequest request) {
            this.asyncContext = asyncContext;
            this.request = request;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(4000);
                //此处通过观察源码，得知需要从request来判断是否超时，否则会一直抛出异常,超时的话，超时参数会置为-1
                if(request.getAsyncContext() != null && asyncContext.getTimeout()>0){
                    try {
                        ServletResponse response = asyncContext.getResponse();
                        response.setCharacterEncoding("utf-8");
                        PrintWriter out = response.getWriter();
                        out.println("----------back-thread-execute-end 后台线程执行完成");
                        log.info("--------------------after back-thread-execute-end");
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    log.info("--------------------before complete");
                    asyncContext.complete();
                    log.info("--------------------after complete");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    class MyAsyncListener implements AsyncListener {

        @Override
        public void onComplete(AsyncEvent asyncEvent) throws IOException {
            try {
                AsyncContext asyncContext = asyncEvent.getAsyncContext();
                ServletResponse response = asyncContext.getResponse();
                ServletRequest request = asyncContext.getRequest();
                response.setCharacterEncoding("utf-8");
                PrintWriter out= response.getWriter();
                if (request.getAttribute("timeout") != null &&
                        StringUtils.equals("true",request.getAttribute("timeout").toString())) {//超时
                    out.println("--------1 后台线程执行超时---【回调】");
                    System.out.println("异步servlet【onComplete超时】");
                }else {//未超时
                    out.println("--------2 后台线程执行完成---【回调】");
                    System.out.println("异步servlet【onComplete完成】");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(AsyncEvent asyncEvent) throws IOException {
            System.out.println("异步servlet错误");
        }

        @Override
        public void onStartAsync(AsyncEvent arg0) throws IOException {
            System.out.println("开始异步servlet");
        }

        @Override
        public void onTimeout(AsyncEvent asyncEvent) throws IOException {
            ServletRequest request = asyncEvent.getAsyncContext().getRequest();
            request.setAttribute("timeout", "true");
            System.out.println("异步servlet【onTimeout超时】");
        }

    }

}
