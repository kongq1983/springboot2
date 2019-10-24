package com.kq.es.controller;

import com.alibaba.fastjson.JSON;
import com.kq.entity.Inventory;
import com.kq.es.enums.IndexEnum;
import com.kq.es.index.DeleteDocumentIndex;
import com.kq.es.util.DomParseXmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * CreateIndexController
 *
 * @author kq
 * @date 2019-10-22
 */
@RestController
@Slf4j
@RequestMapping("/index")
public class CreateIndexController {

    @Autowired
    private com.kq.es.index.CreateDocumentIndex createIndex;

    @Autowired
    private DeleteDocumentIndex deleteDocumentIndex;


    @RequestMapping("/create/{index}")
    public String createIndex(@PathVariable("index") String index) throws Exception{
        log.info("------------start CreateIndexController createIndex");
        StringBuilder str = new StringBuilder();

        List<Inventory> list = DomParseXmlUtil.start();

        if(list!=null) {
            list.forEach(c -> {
                String json = JSON.toJSONString(c);
                try {
                    createIndex.createIndexByJson(index, c.getId(), json,false);
                } catch (Exception e) {
                    log.error("创建索引失败!", e);
                    str.append(e.getMessage());
                    str.append("\n");
                }
            });
        }

        if(str.length()>0) {
            return str.toString();
        }

        return "ok";

    }


    @RequestMapping("/delete/{id}")
    public String deleteDocumentIndex(@PathVariable("id") String id) throws Exception{
        StringBuilder str = new StringBuilder();


        try {
            this.deleteDocumentIndex.delete(IndexEnum.INVENTOYR_1, id);
        }catch (Exception e) {
            log.error("删除索引失败!",e);
            return e.getMessage();
        }

        return "ok";

    }


}
