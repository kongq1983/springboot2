package com.kq.service;

import com.kq.entity.Inventory;
import com.kq.es.mapper.InventoryMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * InventoryServiceTest
 *
 * @author kq
 * @date 2019-10-18
 */


public class InventoryServiceTest extends BaseApplicationTest{

    @Autowired
    private InventoryMapper inventoryMapper;

    @Test
    public void testInventory(){
        List<Inventory> list = inventoryMapper.getInventoryList();

        list.forEach(System.out::println);

    }


}
