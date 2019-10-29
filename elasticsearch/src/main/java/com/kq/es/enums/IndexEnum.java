package com.kq.es.enums;

/**
 * IndexEnum
 *
 * @author1 kq
 * @date 2019-10-22
 */
public enum IndexEnum {

    /** 菜品 */INVENTOYR("inventory"),INVENTOYR_1("inventory1");

    private String index;

    private IndexEnum(String index) {
        this.index = index;
    }

    public String getIndex() {
        return index;
    }
}
