package com.kq.es.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Configuration
 *
 * @author kq
 * @date 2018-12-14
 */

@Slf4j
@Configuration
public class ESConfiguration {

    @Autowired
    private ElasticSearchServerProperties elasticSearchServerProperties;


    @Bean
    @Scope("prototype")
    public RestHighLevelClient getRestHighLevelClient(){

        log.debug("my.elasticsearch.server.url:{}",elasticSearchServerProperties.getUrl());
        log.debug("my.elasticsearch.server.port:{}",elasticSearchServerProperties.getPort());

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(elasticSearchServerProperties.getUrl(),
                                elasticSearchServerProperties.getPort(),
                                    "http")));
//                        new HttpHost("localhost", 9201, "http")));

        return client;
    }



}
