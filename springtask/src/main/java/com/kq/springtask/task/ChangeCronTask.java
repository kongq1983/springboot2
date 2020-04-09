package com.kq.springtask.task;

import com.kq.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;


@Component
public class ChangeCronTask implements SchedulingConfigurer {

    protected static Logger logger = LoggerFactory.getLogger(ChangeCronTask.class);


    /** 默认每隔5s */
    private String cron = "0/5 * * * * *";

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

        // Runnable
        Runnable task = () -> logger.info("{}, ChangeCronTask print", DateUtil.getFormat());

        /**
         * 调度实现的时间控制  nextExecutionTime
         */
        Trigger trigger = (triggerContext) -> {
            CronTrigger cronTrigger=new CronTrigger(cron);
            return cronTrigger.nextExecutionTime(triggerContext);
        };

        scheduledTaskRegistrar.addTriggerTask(task, trigger);

    }

    public void setCron(String cron) {
        this.cron = cron;
    }
}
