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

@SpringBootApplication
@MapperScan("com.kq.mybatis.mapper")
public class MybatisMapperScanApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisMapperScanApplication.class, args);
    }

}
