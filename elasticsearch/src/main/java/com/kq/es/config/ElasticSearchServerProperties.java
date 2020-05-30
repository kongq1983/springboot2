package com.kq.es.config;

import com.kq.es.entity.ESServer;
import org.apache.http.HttpHost;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ElasticSearchServerProperties
 *
 * @author kq
 * @date 2019-10-18
 */

@Component
//@ConfigurationProperties("my.elasticsearch.server")
@ConfigurationProperties("my.elasticsearch")
public class ElasticSearchServerProperties {

    private String url;
    private Integer port;

    private List<ESServer> servers;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public List<ESServer> getServers() {
        return servers;
    }

    public void setServers(List<ESServer> servers) {
        this.servers = servers;
    }

    @Override
    public String toString() {
        return "ElasticSearchServerProperties{" +
                "url='" + url + '\'' +
                ", port=" + port +
                ", servers=" + servers +
                '}';
    }
}
