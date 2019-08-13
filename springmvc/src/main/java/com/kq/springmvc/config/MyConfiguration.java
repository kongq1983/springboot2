package com.kq.springmvc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * MyConfiguration
 * 从application.yml 读取my属性
 * @author kq
 * @date 2019-08-13
 */
@Data
@Component
@ConfigurationProperties("my")
public class MyConfiguration {

    private String name;
    private String username;
    private Integer port;

}
