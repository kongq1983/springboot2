package com.kq.es.config;

import com.kq.es.entity.ESServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BackoffPolicy;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.common.unit.TimeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.net.InetAddress;
import java.util.List;
import java.util.stream.Collectors;

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

//        RestHighLevelClient client = new RestHighLevelClient(
//                RestClient.builder(
//                        new HttpHost(elasticSearchServerProperties.getUrl(),
//                                elasticSearchServerProperties.getPort(),
//                                    "http")));

        List<HttpHost> list = elasticSearchServerProperties.getServers().stream().map(s->{
            return new HttpHost(s.getHostname(),s.getPort(),s.getScheme());
        }).collect(Collectors.toList());

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        list.toArray(new HttpHost[0])));
//                        new HttpHost("localhost", 9201, "http")));

        return client;
    }





}
