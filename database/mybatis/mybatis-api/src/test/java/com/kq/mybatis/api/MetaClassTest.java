package com.kq.mybatis.api;

import com.kq.entity.Account;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class MetaClassTest {

    @Test
    public void test(){

        MetaClass metaClass = MetaClass.forClass(Account.class, new DefaultReflectorFactory());

        String property = metaClass.findProperty("id");
        System.out.println("property="+property);

        Class clazz = metaClass.getGetterType("id");
        System.out.println("clazz="+clazz);

        assertThat(Long.class,equalTo(clazz));
        assertThat(true,equalTo(metaClass.hasGetter("id")));
        assertThat(false,equalTo(metaClass.hasGetter("ids")));

    }

}
