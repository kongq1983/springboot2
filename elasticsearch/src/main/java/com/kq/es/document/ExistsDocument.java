package com.kq.es.document;

import com.kq.es.enums.IndexEnum;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.springframework.stereotype.Component;

/**
 * ExistsDocument
 *
 * @author kq
 * @date 2019-10-25
 */
@Slf4j
@Component
public class ExistsDocument extends BaseIndex{


    /**
     * 判断索引稳定是否存在
     * @param index
     * @param id
     * @return
     * @throws Exception
     */
    public boolean exists(IndexEnum index, String id) throws Exception{

        GetRequest getRequest = new GetRequest(index.getIndex(),DOC, id);
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");

        boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
        return exists;

    }


    public void asyncExists(IndexEnum index, String id) throws Exception{

        GetRequest getRequest = new GetRequest(index.getIndex(),DOC, id);
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");

        ActionListener<Boolean> listener = new ActionListener<Boolean>() {
            @Override
            public void onResponse(Boolean exists) {
                log.info("异步判断文档是否存在 index={} id={} exists={}",index.getIndex(),id,exists);
            }

            @Override
            public void onFailure(Exception e) {
                log.info("异步判断文档是否存在失败! index={} id={} e={}",index.getIndex(),id,e);
            }
        };

        restHighLevelClient.existsAsync(getRequest, RequestOptions.DEFAULT, listener);

    }


}
