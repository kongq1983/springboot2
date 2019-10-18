package com.kq.es.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ElasticSearchServerProperties
 *
 * @author kq
 * @date 2019-10-18
 */

@Data
@Component
@ConfigurationProperties("my.elasticsearch.server")
public class ElasticSearchServerProperties {

    private String url;
    private Integer port;

}
