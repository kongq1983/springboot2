package com.kq.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.TimeUnit;

/**
 * @author kq
 * @date 2020-09-15 18:55
 * @since 2020-0630
 */
@Slf4j
@RestController
@RequestMapping("/async/deferred")
public class DeferredResultController {

    @RequestMapping("/{id}")
    public DeferredResult<ResponseEntity<String>> testProcess(@PathVariable("id") String id) {

        final DeferredResult<ResponseEntity<String>> deferredResult = new DeferredResult<ResponseEntity<String>>(2000L);

        // 业务逻辑异步处理,将处理结果 set 到 DeferredResult
        new Thread(new AsyncTask(deferredResult)).start();

        ResponseEntity<String> result = new ResponseEntity<String>("fail", HttpStatus.OK);
        deferredResult.setResult(result);
        return deferredResult;
    }

    private static class AsyncTask implements Runnable {

        private DeferredResult result;

        private AsyncTask(DeferredResult result) {
            this.result = result;
        }

        @Override
        public void run() {
            log.info("asyncTask execute.");
            //业务逻辑START

            try{
                TimeUnit.SECONDS.sleep(3);
            }catch (Exception e){
                e.printStackTrace();
            }
            //...
            //业务逻辑END
            result.setResult("ok");
        }
    }

}
