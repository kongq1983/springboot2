package com.kq.log.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * @author kq
 * @date 2020-09-08 17:58
 * @since 2020-0630
 */
public class LoginService {

    private Logger logger = LoggerFactory.getLogger(LoginService.class);

    private Logger transactionLogger = LoggerFactory.getLogger("transactionLogger");

    public void print(){
        logger.debug(" this is LoginService print");
        transactionLogger.info("本次花费"+new Random().nextInt(10)+"元");
    }
}
