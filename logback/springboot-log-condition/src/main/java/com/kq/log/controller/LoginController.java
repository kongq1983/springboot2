package com.kq.log.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kq
 * @date 2020-09-08 17:56
 * @since 2020-0630
 */
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    public void print(){
        logger.debug(" this is LoginController print");
    }


}
