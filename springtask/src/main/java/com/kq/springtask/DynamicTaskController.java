package com.kq.springtask;

import com.kq.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ScheduledFuture;

@RestController
public class DynamicTaskController {

    protected static Logger logger = LoggerFactory.getLogger(DynamicTaskController.class);

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture<?> future;

    @Bean
    public ThreadPoolTaskScheduler trPoolTaskScheduler(){
        return new ThreadPoolTaskScheduler();
    }

    /**
     * 1，定义一个方法实现定时任务的启动
     * 2，定义一个方法实现用于终止定时任务
     * 3，修改定时任务时间：changeCron
     */
    /**
     * 启动定时器
     * @return
     */
    @RequestMapping("startTest")
    public String startTest(){
        /**
         * task:定时任务要执行的方法
         * trigger:定时任务执行的时间
         */
        future = threadPoolTaskScheduler.schedule(new MyRunable(),new CronTrigger("0/5 * * * * *") );

        return "startTest";
    }

    /**
     * 停止定时任务
     * @return
     */
    @RequestMapping("endTask")
    public String endTask(){
        if(future!=null){
            future.cancel(true);
        }
        System.out.println("endTask");
        return "endTask";
    }

    /**
     * 改变调度的时间
     * 步骤：
     * 1,先停止定时器
     * 2,在启动定时器
     */
    @RequestMapping("changeTask")
    public String changeTask(){
        //停止定时器
        endTask();
        //定义新的执行时间
        future=threadPoolTaskScheduler.schedule(new MyRunable(),new CronTrigger("0/10 * * * * *") );
        //启动定时器
        startTest();
        System.out.println("changeTask");
        return "changeTask";
    }

    /**
     * 定义定时任务执行的方法
     * @author Admin
     *
     */
    public class MyRunable implements Runnable{
        @Override
        public void run() {
            logger.info("{}, PrintTask print", DateUtil.getFormat());
        }

    }


}
