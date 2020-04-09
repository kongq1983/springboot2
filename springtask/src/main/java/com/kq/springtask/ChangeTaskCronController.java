package com.kq.springtask;


import com.kq.springtask.task.ChangeCronTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChangeTaskCronController {

    protected static Logger logger = LoggerFactory.getLogger(ChangeTaskCronController.class);

    @Autowired
    private ChangeCronTask changeCronTask;


    @RequestMapping("/changeSecond")
    public String changeSecondCron(@RequestParam("second") Integer second){

        if(second==null||second.intValue()<0){
            second = 6;
        }

        logger.info("change cron task , second={}",second);

        String cron ="0/"+second+" * * * * *";

        changeCronTask.setCron(cron);

        return "ok";
    }


}
