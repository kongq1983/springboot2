package com.kq.es.index;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * CreateIndex
 *
 * @author kq
 * @date 2019-10-18
 */
@Component
public class CreateIndex {


    public void createIndexByJson(String index, String id,String json) {

        IndexRequest request = null;
        if(StringUtils.hasText(id)) {
            request = new IndexRequest(index,"doc",id);
        } else {
            request = new IndexRequest(index,"doc");
        }

        request.source(json, XContentType.JSON);

    }

    public void createIndexByMap(String index, String id, Map<String,Object> map) {

        IndexRequest request = null;
        if(StringUtils.hasText(id)) {
            request = new IndexRequest(index,"doc",id);
        } else {
            request = new IndexRequest(index,"doc");
        }

        request.source(map);

    }

}
