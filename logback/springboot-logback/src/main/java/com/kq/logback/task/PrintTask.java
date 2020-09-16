package com.kq.logback.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author kq
 * @date 2020-09-08 16:17
 * @since 2020-0630
 */

@Component
public class PrintTask {

    protected Logger logger = LoggerFactory.getLogger(PrintTask.class);


    @Scheduled(fixedRate=5000)
    public void run() {

        logger.info("------------------开始定时器启动");

//        try {
//            TimeUnit.SECONDS.sleep(1);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        logger.info("------------------开始定时器结束");

    }

}
