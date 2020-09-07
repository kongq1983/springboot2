package com.kq.timer.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class TaskOne {

    protected Logger logger = LoggerFactory.getLogger(TaskOne.class);

    private AtomicInteger ato = new AtomicInteger();



    //    @Scheduled(cron="0 */5 * * * ?")   //每5分钟执行一次
//    @Scheduled(cron="0 */1 * * * ?")   //每1分钟执行一次
    @Scheduled(fixedDelay=30*1000)   //每30s执行一次
    public void send(){

        int num = ato.getAndIncrement();
        logger.info("index={} , start run send mail. ",num);

    }


}
