package com.kq.log.task;

import com.kq.log.controller.LoginController;
import com.kq.log.dao.LoginDao;
import com.kq.log.service.LoginService;
import com.kq.log.sql.LoginSql;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2020-09-08 16:17
 * @since 2020-0630
 */

@Component
public class LoginTask {

    protected Logger logger = LoggerFactory.getLogger(LoginTask.class);

    LoginController loginController = new LoginController();
    LoginDao loginDao = new LoginDao();
    LoginService loginService = new LoginService();
    LoginSql loginSql = new LoginSql();


    @Scheduled(fixedRate=5000)
    public void run() {

        logger.info("------------------LoginTask启动");

        loginController.print();
        this.loginService.print();
        this.loginDao.print();
        this.loginSql.print();

//        try {
//            TimeUnit.SECONDS.sleep(1);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        logger.info("------------------LoginTask结束");

    }

}
