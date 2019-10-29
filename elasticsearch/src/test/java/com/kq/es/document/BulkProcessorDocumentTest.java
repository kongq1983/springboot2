package com.kq.es.document;

import com.alibaba.fastjson.JSON;
import com.kq.dto.IndexDto;
import com.kq.entity.Inventory;
import com.kq.es.util.DomParseXmlUtil;
import com.kq.service.BaseApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * BulkProcessorDocumentTest
 *
 * @author kq
 * @date 2019-10-25
 */
public class BulkProcessorDocumentTest extends BaseApplicationTest {

    @Autowired
    private BulkProcessorDocument bulkProcessorDocument;

    @Test
    public void testInsert() throws Exception {

        List<Inventory> list = DomParseXmlUtil.start();

        List<IndexDto> inventoryList = new ArrayList<>();

        int id = 0;
        for(Inventory inventory : list) {
            id++;
            String json = JSON.toJSONString(inventory);
            inventory.setId(String.valueOf(id));

            IndexDto dto = new IndexDto();
            dto.setId(String.valueOf(id));
            dto.setIndex("inventory6");
            dto.setJson(json);
            inventoryList.add(dto);

        }

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        bulkProcessorDocument.createIndexByJson(inventoryList);

        stopWatch.stop();
        System.out.println("spent time : "+stopWatch.getTotalTimeSeconds()+"s");

    }

}
