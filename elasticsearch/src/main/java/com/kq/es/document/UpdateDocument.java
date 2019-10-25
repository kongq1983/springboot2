package com.kq.es.document;

import com.alibaba.fastjson.JSON;
import com.kq.es.enums.IndexEnum;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Component;

/**
 * UpdateIndex
 *
 * @author kq
 * @date 2019-10-22
 */
@Slf4j
@Component
public class UpdateDocument extends BaseIndex{

    public void update(IndexEnum indexEnum,String id, Object object) throws Exception{
        String json = JSON.toJSONString(object);
        update(indexEnum,id, json);
    }

    public void update(IndexEnum indexEnum,String id, String json) throws Exception{

        UpdateRequest request = new UpdateRequest(indexEnum.getIndex(),DOC, id);

        request.doc(json, XContentType.JSON);

        UpdateResponse updateResponse = this.restHighLevelClient.update( request, RequestOptions.DEFAULT);

        restHighLevelClient.close();

        log.info("id={} 返回值{}",id,updateResponse);

    }

}
