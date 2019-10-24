package com.kq.es.controller;

import com.alibaba.fastjson.JSON;
import com.kq.es.mapper.InventoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * CreateIndexController
 *
 * @author kq
 * @date 2019-10-22
 */
@RequestMapping
@RestController
@Slf4j
public class CreateIndexController {

    @Autowired
    private com.kq.es.index.CreateIndex createIndex;

    @Autowired
    private InventoryMapper inventoryMapper;


    @RequestMapping("/createIndex")
    public String createIndex(){
        log.info("------------start CreateIndexController createIndex");
        StringBuilder str = new StringBuilder();
        inventoryMapper.getInventoryList().forEach(c-> {
            String json = JSON.toJSONString(c);
            try {
                createIndex.createIndexByJson("inventory", c.getId(), json);
            }catch (Exception e){
                log.error("创建索引失败!",e);
                str.append(e.getMessage());
                str.append("\n");
            }
        });

        if(str.length()>0) {
            return str.toString();
        }

        return "ok";

    }


}
