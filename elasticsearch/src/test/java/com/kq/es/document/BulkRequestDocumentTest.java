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
 * BulkRequestDocumentTest
 *
 * @author kq
 * @date 2019-10-25
 */
public class BulkRequestDocumentTest extends BaseApplicationTest {

    @Autowired
    private BulkRequestDocument bulkRequestDocument;

    @Test
    public void createIndexTest() throws Exception{



        List<Inventory> list = DomParseXmlUtil.start();

        List<IndexDto> inventoryList = new ArrayList<>();

        int id = 0;
        for(Inventory inventory : list) {
            id++;
            String json = JSON.toJSONString(inventory);
            inventory.setId(String.valueOf(id));

            IndexDto dto = new IndexDto();
            dto.setId(String.valueOf(id));
            dto.setIndex("inventory2");
            dto.setJson(json);
            inventoryList.add(dto);

        }

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        bulkRequestDocument.createIndexByJson(inventoryList);

        stopWatch.stop();
        System.out.println("spent time : "+stopWatch.getTotalTimeSeconds()+"s");

        TimeUnit.SECONDS.sleep(5);

    }

    @Test
    public void createMyIndex() throws Exception{
        List<IndexDto> inventoryList = new ArrayList<>();

        Inventory inventory = new Inventory();
        inventory.setName("红烧鲫鱼");
        inventory.setId("1000");

        String json = JSON.toJSONString(inventory);

        IndexDto dto = new IndexDto();
        dto.setIndex("inventory5");
        dto.setJson(json);
        dto.setId(inventory.getId());
        inventoryList.add(dto);


        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        bulkRequestDocument.createIndexByJson(inventoryList);

        stopWatch.stop();
        System.out.println("spent time : "+stopWatch.getTotalTimeSeconds()+"s");

        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    public void testCreateTemp() throws Exception{
        this.bulkRequestDocument.createTemp("mytmp");
    }

}
