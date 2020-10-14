package com.kq.aop.service;

import org.springframework.stereotype.Service;

/**
 * @author kq
 * @date 2020-10-10 10:42
 * @since 2020-0630
 */
@Service
public class PersonService {

    public void addPerson(String personName) {
        System.out.println("添加用户 - add person " + personName);
    }

    public boolean deletePerson(String personName) {
        System.out.println("delete person " + personName) ;
        return true;
    }

    public void editPerson(String personName) {
        System.out.println("edit person " + personName);
        throw new RuntimeException("edit person throw exception");
    }
}
