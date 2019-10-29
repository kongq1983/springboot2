package com.kq.jdbc1.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * InsertDataConfiguration
 * see:  https://docs.spring.io/spring-boot/docs/current/reference/html/howto-data-access.html#howto-configure-a-datasource
 * @author kq
 * @date 2019-10-11
 */
@Slf4j
@Configuration
public class InsertDataConfiguration {

//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource.hikari")
//    public DataSourceProperties xxDS2Properties() {
//        return new DataSourceProperties();
//    }


    @Autowired
    private DataSource dataSource;

//    @Bean
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        return dataSourceBuilder.build();
//    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }

}
