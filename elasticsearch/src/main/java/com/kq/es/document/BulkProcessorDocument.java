package com.kq.es.document;

import com.kq.dto.IndexDto;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/**
 * BulkProcessorDocument
 *
 * @author kq
 * @date 2019-10-25
 */
@Slf4j
@Component
public class BulkProcessorDocument extends BaseIndex{

    public void createIndexByJson(List<IndexDto> indexDtos) throws Exception{

        BulkProcessor.Listener listener = new BulkProcessor.Listener() {
            @Override
            public void beforeBulk(long executionId, BulkRequest request) {
                int numberOfActions = request.numberOfActions();
                log.debug("beforeBulk Executing bulk [{}] with {} requests",
                        executionId, numberOfActions);
            }

            @Override
            public void afterBulk(long executionId, BulkRequest request,
                                  BulkResponse response) {

                if (response.hasFailures()) {
                    log.warn("afterBulk Bulk [{}] executed with failures", executionId);
                } else {
                    log.debug("afterBulk Bulk [{}] completed in {} milliseconds",
                            executionId, response.getTook().getMillis());
                }

            }

            @Override
            public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
                log.error("afterBulk Error,  Failed to execute bulk", failure);
            }
        };

        BiConsumer<BulkRequest, ActionListener<BulkResponse>> bulkConsumer =
                (request, bulkListener) -> restHighLevelClient.bulkAsync(request, RequestOptions.DEFAULT, bulkListener);

        BulkProcessor bulkProcessor = BulkProcessor.builder(bulkConsumer, listener).build();


        for(IndexDto dto : indexDtos) {
            log.info(" IndexDto dto={}",dto);
            bulkProcessor.add(new IndexRequest(dto.getIndex(), DOC, dto.getId())
                    .source(dto.getJson(), XContentType.JSON));
        }

//        The awaitClose() method can be used to wait until all requests
//        have been processed or the specified waiting time elapses
        boolean terminated = bulkProcessor.awaitClose(60L, TimeUnit.SECONDS);

        log.info("terminated={}",terminated);

    }

}
