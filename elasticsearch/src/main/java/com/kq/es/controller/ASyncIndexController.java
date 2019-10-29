package com.kq.es.controller;

import com.kq.es.document.ExistsDocument;
import com.kq.es.enums.IndexEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ASyncIndexController
 *
 * @author kq
 * @date 2019-10-25
 */
@RestController
@Slf4j
@RequestMapping("/async/index")
public class ASyncIndexController {

    @Autowired
    private ExistsDocument existsDocument;


    @RequestMapping("/exists/{id}")
    public String existsDocumentIndex(@PathVariable("id") String id) throws Exception{
        StringBuilder str = new StringBuilder();

        try {
            this.existsDocument.asyncExists(IndexEnum.INVENTOYR_1, id);
        }catch (Exception e) {
            log.error("删除索引失败!",e);
            return e.getMessage();
        }

        return "ok";

    }


}
