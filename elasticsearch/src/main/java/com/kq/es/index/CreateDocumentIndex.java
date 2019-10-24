package com.kq.es.index;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * CreateIndex
 *
 * @author kq
 * @date 2019-10-18
 */
@Slf4j
@Component
public class CreateDocumentIndex extends BaseIndex{


    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public void createIndexByJson(String index, String id,String json,boolean close) throws Exception{

        IndexRequest request = null;
        if(StringUtils.hasText(id)) {
            request = new IndexRequest(index,DOC,id);
        } else {
            request = new IndexRequest(index,DOC);
        }

        request.source(json, XContentType.JSON);

        IndexResponse indexResponse = restHighLevelClient.index(request, RequestOptions.DEFAULT);

        log.info("create index response data : {}",indexResponse);

        if(close) {
            restHighLevelClient.close();
        }

    }

    public void createIndexByMap(String index, String id, Map<String,Object> map) throws Exception{

        IndexRequest request = null;
        if(StringUtils.hasText(id)) {
            request = new IndexRequest(index,DOC,id);
        } else {
            request = new IndexRequest(index,DOC);
        }

        request.source(map);

        IndexResponse indexResponse = restHighLevelClient.index(request, RequestOptions.DEFAULT);

        log.info("create index response data : {}",indexResponse);

        restHighLevelClient.close();

    }

}
