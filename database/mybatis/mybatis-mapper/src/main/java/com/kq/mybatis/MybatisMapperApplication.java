package com.kq.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MybatisMapperScanApplication
 *
 * @author kq
 * @date 2019-10-12
 */
@MapperScan("com.kq")
@SpringBootApplication
public class MybatisMapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisMapperApplication.class, args);
    }

}
