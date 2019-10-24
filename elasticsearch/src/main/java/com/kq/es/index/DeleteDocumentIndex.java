package com.kq.es.index;

import com.kq.es.enums.IndexEnum;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.TimeValue;
import org.springframework.stereotype.Component;

/**
 * DeleteDocumentIndex
 *
 * @author kq
 * @date 2019-10-24
 */
@Slf4j
@Component
public class DeleteDocumentIndex extends BaseIndex{

    /**
     * 删除Document
     * @param indexEnum  索引枚举
     * @param id ID
     * @throws Exception
     */
    public void delete(IndexEnum indexEnum,String id) throws Exception{
        DeleteRequest request = new DeleteRequest( indexEnum.getIndex(), DOC, id);
        request.timeout(TimeValue.timeValueSeconds(3));
        request.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);

        DeleteResponse deleteResponse = restHighLevelClient.delete(
                request, RequestOptions.DEFAULT);

        log.info("删除索引={} id={} result={}",indexEnum.getIndex(),id,deleteResponse);

        restHighLevelClient.close();
    }

}
