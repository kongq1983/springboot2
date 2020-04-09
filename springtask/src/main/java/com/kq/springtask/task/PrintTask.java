package com.kq.springtask.task;

import com.kq.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PrintTask {

    protected static Logger logger = LoggerFactory.getLogger(PrintTask.class);


    @Scheduled(cron="0/10 * * * * *")
    public void print(){
        logger.info("{}, PrintTask print", DateUtil.getFormat());
    }


}
