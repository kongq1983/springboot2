package com.kq.es.export;

import com.kq.entity.Inventory;
import com.kq.es.mapper.InventoryMapper;
import com.kq.es.util.InventoryWriteToXml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ExportInventory
 * 数据导出到xml
 * @author kq
 * @date 2019-10-24
 */
@Component
public class ExportInventory {

    @Autowired
    private InventoryMapper inventoryMapper;

    public void exportToXml(){
        List<Inventory> list = inventoryMapper.getInventoryList();

        InventoryWriteToXml.createXml(list);

    }

}
