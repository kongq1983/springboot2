package com.kq.jdbc2.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Jdbc2Config
   see:  https://docs.spring.io/spring-boot/docs/current/reference/html/howto-data-access.html#howto-configure-a-datasource
 * @author kq
 * @date 2019-10-12
 */
@Configuration
public class Jdbc2Config {

    @Bean
    @Primary
    @ConfigurationProperties("my.datasource.ds1")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("my.datasource.ds1.configuration")
    public HikariDataSource dataSource1() {
        return firstDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    @ConfigurationProperties("my.datasource.ds2")
    public DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("my.datasource.ds2.configuration")
    public HikariDataSource dataSource2() {
        return secondDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }


    @Bean("jdbcTemplateDs1")
    public JdbcTemplate jdbcTemplate1(){
        return new JdbcTemplate(dataSource1());
    }

    @Bean("jdbcTemplateDs2")
    public JdbcTemplate jdbcTemplate2(){
        return new JdbcTemplate(dataSource2());
    }

}
