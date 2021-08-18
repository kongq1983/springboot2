package com.kq.es.document;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.kq.dto.IndexDto;
import com.kq.entity.Inventory;
import com.kq.es.csv.SaleOrderReader;
import com.kq.es.entity.SaleOrder;
import com.kq.service.BaseApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author kq
 * @date 2021-01-20 10:04
 * @since 2020-0630
 */
public class SaleOrderCreateDocumentTest extends BaseApplicationTest {

    @Autowired
    private BulkRequestDocument bulkRequestDocument;

    /**
     * 創建索引
     * @throws Exception
     */
    @Test
    public void createSaleOrderIndex() throws Exception{

        List<SaleOrder> list = SaleOrderReader.getSaleOrderList();

        List<IndexDto> indexs = new ArrayList<>();
        int i = 0;

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for(SaleOrder o : list) {
            String json = JSON.toJSONString(o);

            IndexDto dto = new IndexDto();
            dto.setId(String.valueOf(o.getSaleOrderId()));
//            dto.setIndex("saleorder");
            dto.setIndex("myorder");
            dto.setJson(json);

            indexs.add(dto);

            if(i>1000) {
                bulkRequestDocument.createIndexByJson(Lists.newArrayList(indexs));
                indexs.clear();
                i=0;
                TimeUnit.MILLISECONDS.sleep(10);
            }

            i++;
        }

        bulkRequestDocument.createIndexByJson(indexs);

        stopWatch.stop();
        System.out.println("spent time : "+stopWatch.getTotalTimeSeconds()+"s");


        System.out.println("===========================================================");
        TimeUnit.SECONDS.sleep(3600);


    }

}
