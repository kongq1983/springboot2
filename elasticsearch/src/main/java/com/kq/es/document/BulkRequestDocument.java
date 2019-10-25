package com.kq.es.document;

import com.alibaba.fastjson.JSON;
import com.kq.dto.Email;
import com.kq.dto.IndexDto;
import com.kq.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * BulkRequest
 *
 * @author kq
 * @date 2019-10-25
 */
@Slf4j
@Component
public class BulkRequestDocument extends BaseIndex{

    public void createTemp(String index) throws Exception{
        BulkRequest request = new BulkRequest();

        Long id = 3L;
        User user = new User();
        user.setName("king");
        user.setId(id);
        String json = JSON.toJSONString(user);

        request.add(new IndexRequest(index, "doc", String.valueOf(id))
                .source(json,XContentType.JSON));

        this.restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
    }

    public void createIndexByJson(List<IndexDto> indexDtos) throws Exception{

        if(indexDtos==null) {
            return;
        }

        BulkRequest request = new BulkRequest();
        request.timeout(TimeValue.timeValueSeconds(3));
//        request.timeout(TimeValue.timeValueMinutes(5));

        for(IndexDto dto : indexDtos) {
            log.info(" IndexDto dto={}",dto);
            request.add(new IndexRequest(dto.getIndex(), DOC, dto.getId())
                    .source(dto.getJson(),XContentType.JSON));
        }


        ActionListener<BulkResponse> listener = new ActionListener<BulkResponse>() {
            @Override
            public void onResponse(BulkResponse bulkResponse) {

                for (BulkItemResponse bulkItemResponse : bulkResponse) {
                    DocWriteResponse itemResponse = bulkItemResponse.getResponse();

                    if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.INDEX
                            || bulkItemResponse.getOpType() == DocWriteRequest.OpType.CREATE) {
                        IndexResponse indexResponse = (IndexResponse) itemResponse;
                        log.info("INDEX CREATE , indexResponse={}",indexResponse);

                    } else if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.UPDATE) {
                        UpdateResponse updateResponse = (UpdateResponse) itemResponse;
                        log.info("INDEX UPDATE , indexResponse={}",updateResponse);

                    } else if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.DELETE) {
                        DeleteResponse deleteResponse = (DeleteResponse) itemResponse;
                        log.info("INDEX DELETE , deleteResponse={}",deleteResponse);
                    }
                }

            }

            @Override
            public void onFailure(Exception e) {
                log.error("操作索引报错!",e);
            }
        };


        this.restHighLevelClient.bulkAsync(request, RequestOptions.DEFAULT, listener);


    }


}
