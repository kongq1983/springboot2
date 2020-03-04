package com.kq.config.more;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MoreActiveConfigApplication {

//    private static Logger logger = LoggerFactory.getLogger(MoreActiveConfigApplication.class);

    public static void main(String[] args) {
        // userDir = E:\zyzhworkspace\springboot2
        // 配置文件config  放E:\zyzhworkspace\springboot2\config
        String userDir = System.getProperty("user.dir");
//        logger.info("user.dir="+userDir);
        ConfigurableApplicationContext context = SpringApplication.run(MoreActiveConfigApplication.class, args);
    }


}
