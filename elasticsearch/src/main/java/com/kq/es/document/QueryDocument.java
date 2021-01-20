package com.kq.es.document;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.*;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author kq
 * @date 2021-01-20 13:57
 * @since 2020-0630
 */
@Slf4j
@Component
public class QueryDocument extends BaseIndex{

    public void search0(){

    }

    public void search() throws Exception{

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.termQuery("name", "孔"));
        sourceBuilder.from(0);
        sourceBuilder.size(10);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.source(sourceBuilder);
        searchRequest.indices("saleorder");

        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        String scrollId = searchResponse.getScrollId();
        SearchHits hits = searchResponse.getHits();

        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit : searchHits) {

            String index = hit.getIndex();
            String type = hit.getType();
            String id = hit.getId();
            float score = hit.getScore();
            String sourceAsString = hit.getSourceAsString();
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();

            System.out.println("id="+id+", type="+type+",index="+index+",score="+score+",sourceAsString="+sourceAsString);
            System.out.println("sourceAsMap="+sourceAsMap);

        }


//        //按照得分情况降序
//        sourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));
////按照id字段情况升序
//        sourceBuilder.sort(new FieldSortBuilder("id").order(SortOrder.ASC));

    }

    public List<String> baseProductShopNotExistEsSearch() {
        try {
            SearchRequest searchRequest = new SearchRequest("saleorder");
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            sourceBuilder.fetchSource("shop_code", null);//过滤门店编码为null数据
//            if (CollectionUtils.isNotEmpty(ids)) {
//                ids=ids.stream().distinct().collect(Collectors.toList());
//                sourceBuilder.query(QueryBuilders.termsQuery(EsUtils.ID, ids));//根据ID查询
//            }else{
//                throw new RRException("请求参数不能为空");
//            }
            sourceBuilder.timeout(TimeValue.timeValueMinutes(2L));
            sourceBuilder.size(10);//分页量
//            sourceBuilder.sort(EsUtils.ID, SortOrder.DESC);//排序
            searchRequest.source(sourceBuilder);
            //scroll 分页搜索
            Scroll scroll = new Scroll(TimeValue.timeValueMinutes(1L));
            searchRequest.scroll(scroll);
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            String scrollId = searchResponse.getScrollId();
            SearchHit[] searchHits = searchResponse.getHits().getHits();
            List<String> mapList = Lists.newArrayList();
            ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
            while (true) {
                if(StringUtils.isNotBlank(scrollId)){
                    clearScrollRequest.addScrollId(scrollId);
                }
                if(searchHits == null || searchHits.length == 0){
                    break;
                }
                Arrays.stream(searchHits).forEach(hit -> mapList.add(hit.getId()));
                SearchScrollRequest scrollRequest = new SearchScrollRequest(scrollId);
                scroll = new Scroll(TimeValue.timeValueMinutes(1L));
                scrollRequest.scroll(scroll);
                searchResponse = restHighLevelClient.scroll(scrollRequest, RequestOptions.DEFAULT);
                scrollId = searchResponse.getScrollId();
                searchHits = searchResponse.getHits().getHits();
            }
            ClearScrollResponse clearScrollResponse = restHighLevelClient.clearScroll(clearScrollRequest, RequestOptions.DEFAULT);
            boolean succeeded = clearScrollResponse.isSucceeded();
            if(!succeeded){
                throw new Exception("清除es游标失败");
            }



        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }


}
