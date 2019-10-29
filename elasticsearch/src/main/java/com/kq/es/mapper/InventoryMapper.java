package com.kq.es.mapper;

import com.kq.entity.Inventory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * InventoryMapper
 *
 * @author1 kq
 * @date 2019-10-18
 */
@Mapper
public interface InventoryMapper {

    public List<Inventory> getInventoryList();

}
