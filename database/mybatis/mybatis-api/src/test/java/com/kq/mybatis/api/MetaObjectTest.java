package com.kq.mybatis.api;

import com.kq.entity.Account;
import com.kq.entity.School;
import com.kq.entity.Teacher;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.reflection.wrapper.BeanWrapper;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class MetaObjectTest {

    @Test
    public void testEntity(){
        Teacher teacher = new Teacher();
        teacher.setId(1L);
        teacher.setUsername("teacher.wang");
        School school = new School();
        school.setId(10L);
        school.setName("the-first-school");
        teacher.setSchool(school);

        MetaObject metaObject = MetaObject.forObject(teacher, new DefaultObjectFactory(), new DefaultObjectWrapperFactory(), new DefaultReflectorFactory());

        assertThat(metaObject.getValue("username"),equalTo("teacher.wang"));
        assertThat(metaObject.getValue("school.name"),equalTo("the-first-school"));
    }

    @Test
    public void testMap(){
        Map<String,Object> map = new HashMap();
        map.put("param1","hello");

        Account account = new Account();
        account.setId(8L);
        account.setUsername("admin");

        Teacher teacher = new Teacher();
        teacher.setId(1L);
        teacher.setUsername("teacher.wang");
        School school = new School();
        school.setId(10L);
        school.setName("the-first-school");
        teacher.setSchool(school);


        map.put("account",account);
        map.put("teacher",teacher);
        List<Account> list = new ArrayList();

        for(long i=0;i<=5;i++) {
            Account account1 = new Account();
            account1.setId(i);
            account1.setUsername("admin"+i);
            list.add(account1);
        }
        map.put("accounts",list);



        MetaObject metaObject = MetaObject.forObject(map, new DefaultObjectFactory(), new DefaultObjectWrapperFactory(), new DefaultReflectorFactory());
        metaObject.setValue("a","hello");

        assertThat(metaObject.getValue("a"),equalTo("hello"));
        assertThat(metaObject.getValue("param1"),equalTo("hello"));

        assertThat(metaObject.getValue("account.username"),equalTo("admin"));
        assertThat(metaObject.getValue("account.id"),equalTo(8L));

        assertThat(metaObject.getValue("teacher.username"),equalTo("teacher.wang"));
        assertThat(metaObject.getValue("teacher.school.name"),equalTo("the-first-school"));
        assertThat(metaObject.getValue("accounts[2].id"),equalTo(2L));

    }


    /**
     * CollectionWrapper只支持add、addAll
     * 由于CollectionWrapper不支持get，通过包装BeanWrapper来访问集合的属性
     */
    @Test
    public void testCollection(){
        List<Account> list = new ArrayList();

        for(long i=0;i<=5;i++) {
            Account account = new Account();
            account.setId(i);
            account.setUsername("admin"+i);
            list.add(account);
        }

        MetaObject metaObject = MetaObject.forObject(list, new DefaultObjectFactory(), new DefaultObjectWrapperFactory(), new DefaultReflectorFactory());

        Account account = new Account();
        account.setId(100L);
        account.setUsername("guest");
        metaObject.add(account); // CollectionWrapper

        BeanWrapper beanWrapper = new BeanWrapper(metaObject, list);
        Account account1 = (Account)beanWrapper.get(new PropertyTokenizer("[2]"));
//        Long id = (Long)beanWrapper.get(new PropertyTokenizer("[0].id"));
        assertThat(account1.getId(),equalTo(2L));

    }

}
