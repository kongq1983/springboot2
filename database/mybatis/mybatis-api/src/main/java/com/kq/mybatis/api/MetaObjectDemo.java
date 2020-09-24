package com.kq.mybatis.api;

import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;

import java.util.HashMap;
import java.util.Map;

public class MetaObjectDemo {

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap();
        MetaObject metaObject = MetaObject.forObject(map, new DefaultObjectFactory(), new DefaultObjectWrapperFactory(), new DefaultReflectorFactory());
        metaObject.setValue("a","hello");

        System.out.println(metaObject.getValue("a"));
    }

}
