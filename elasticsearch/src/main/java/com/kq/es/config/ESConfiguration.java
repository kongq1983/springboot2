package com.kq.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration
 *
 * @author kq
 * @date 2018-12-14
 */

@Configuration
public class ESConfiguration {

    @Autowired
    private ElasticSearchServerProperties elasticSearchServerProperties;


    @Bean
    public RestHighLevelClient getRestHighLevelClient(){
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(elasticSearchServerProperties.getUrl(),
                                elasticSearchServerProperties.getPort(),
                                    "http")));
//                        new HttpHost("localhost", 9201, "http")));

        return client;
    }



}
