package com.kq.scan.mybatis;

import com.kq.scan.common.MybatisBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MybatisMapperScanApplication
 *
 * @author kq
 * @date 2019-10-12
 */

@SpringBootApplication
@MapperScans({@MapperScan("com.kq.mybatis.mapper"),@MapperScan("com.kq.mybatis1.mapper")})
//@MapperScans()
//@MapperScan(value = {"com.kq.scan.mybatis.mapper","com.kq.scan.mybatis1.mapper"},markerInterface = MybatisBaseMapper.class,annotationClass=Mapper.class)
public class MybatisMapperScanApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisMapperScanApplication.class, args);
    }

}
