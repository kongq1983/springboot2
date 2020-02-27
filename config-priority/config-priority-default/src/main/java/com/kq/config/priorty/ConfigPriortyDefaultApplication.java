package com.kq.config.priorty;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConfigPriortyDefaultApplication {

    private static Logger logger = LoggerFactory.getLogger(ConfigPriortyDefaultApplication.class);

    public static void main(String[] args) {
        // userDir = E:\zyzhworkspace\springboot2
        // 配置文件config  放E:\zyzhworkspace\springboot2\config
        String userDir = System.getProperty("user.dir");
        logger.info("user.dir="+userDir);
        ConfigurableApplicationContext context = SpringApplication.run(ConfigPriortyDefaultApplication.class, args);
    }

}
