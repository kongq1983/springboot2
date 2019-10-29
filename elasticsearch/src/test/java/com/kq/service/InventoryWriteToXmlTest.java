package com.kq.service;

import com.kq.es.export.ExportInventory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * InventoryWriteToXmlTest
 *
 * @author kq
 * @date 2019-10-24
 */
public class InventoryWriteToXmlTest extends BaseApplicationTest{

    @Autowired
    private ExportInventory exportInventory;


    @Test
    public void test() {
        exportInventory.exportToXml();
    }

}
