package com.kq.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * http://localhost:10001/async/deferred/async/11
 * @author kq
 * @date 2020-09-15 18:55
 * @since 2020-0630
 */
@Slf4j
@RestController
@RequestMapping("/async/deferred")
public class DeferredResultController {

    private AtomicLong atomicLong = new AtomicLong(0);

    ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(5000);

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(50,50,5,TimeUnit.SECONDS,arrayBlockingQueue);

    public DeferredResultController(){
        threadPoolExecutor.prestartAllCoreThreads();
        log.info("DeferredResultController");
    }

    /**
     * http://localhost:10001/async/deferred/async/11
     * @param id
     * @return
     */
    @RequestMapping("/sync/{id}")
    public DeferredResult<ResponseEntity<String>> testProcess(@PathVariable("id") String id) {

//        final DeferredResult<ResponseEntity<String>> deferredResult = new DeferredResult<ResponseEntity<String>>(8000L);
        final DeferredResult<ResponseEntity<String>> deferredResult = new DeferredResult<>();

        Long sign = atomicLong.incrementAndGet();

        deferredResult.onTimeout(()->{
            //超时后调用
            log.info("{}------------------time out",sign);
            deferredResult.setErrorResult(sign+" is timeout");
        });

        deferredResult.onCompletion(()->{
            // 本方法在setResult输出结果后，调用
            log.info("{} is execute success.",sign);
//            ResponseEntity<String> result = new ResponseEntity<String>("success", HttpStatus.OK);
//            deferredResult.setResult(result);
        });

        // 业务逻辑异步处理,将处理结果 set 到 DeferredResult
//        new Thread(new AsyncTask(deferredResult)).start();
        threadPoolExecutor.execute(new AsyncTask(sign,deferredResult));

//        ResponseEntity<String> result = new ResponseEntity<String>("fail", HttpStatus.OK);
//        deferredResult.setResult(result);
        return deferredResult;
    }

    private static class AsyncTask implements Runnable {

        private DeferredResult result;
        private Long sign;

        private AsyncTask(Long sign,DeferredResult result) {
            this.result = result;
            this.sign = sign;
        }

        @Override
        public void run() {
            log.info("asyncTask execute.");
            //业务逻辑START
            log.info("start----------------------------{}",sign);
            try{
                TimeUnit.SECONDS.sleep(5);
            }catch (Exception e){
                e.printStackTrace();
            }
            log.info("e-n-d----------------------------{}",sign);
            //...
            //业务逻辑END
            result.setResult(sign+" is ok");
        }
    }

    /**
     * http://localhost:10001/async/deferred/runAsync/11
     * @param id
     * @return
     */
    @RequestMapping("/runAsync/{id}")
    public DeferredResult<String> testProcess1(@PathVariable("id") String id) {

//        final DeferredResult<String> deferredResult = new DeferredResult<>(5000L);
        final DeferredResult<String> deferredResult = new DeferredResult<>();
        Long sign = atomicLong.incrementAndGet();

        deferredResult.onTimeout(()->{
            //超时后调用
            log.info("------------------time out");
            deferredResult.setErrorResult("timeout");
        });

        deferredResult.onCompletion(()->{
            // 本方法在setResult输出结果后，调用
            log.info("execute success.");
//            ResponseEntity<String> result = new ResponseEntity<String>("success", HttpStatus.OK);
//            deferredResult.setResult(result);
        });

        // 业务逻辑异步处理,将处理结果 set 到 DeferredResult
//        new Thread(new AsyncTask(deferredResult)).start();


        CompletableFuture.runAsync(() -> {
            new AsyncTask(sign,deferredResult).run();
        });

//        deferredResult.setResult("good");

        return deferredResult;
    }

}
