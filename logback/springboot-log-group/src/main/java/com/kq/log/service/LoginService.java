package com.kq.log.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kq
 * @date 2020-09-08 17:58
 * @since 2020-0630
 */
public class LoginService {

    private Logger logger = LoggerFactory.getLogger(LoginService.class);

    public void print(){
        logger.debug(" this is LoginService print");
    }
}
