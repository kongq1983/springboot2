package com.kq.jdbc1.service.impl;

import com.kq.jdbc1.entity.Account;
import com.kq.jdbc1.entity.Person;
import com.kq.jdbc1.entity.User;
import com.kq.jdbc1.service.AccountExService;
import com.kq.jdbc1.service.CommonService;
import com.kq.jdbc1.service.PersonService;
import com.kq.jdbc1.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CommonServiceImpl
 *
 * @author kq
 * @date 2020-01-06
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private UserService userService;
    @Autowired
    private PersonService personService;
    @Autowired
    private AccountExService accountExService;

    @Override
    public void insert(Account account) {

        User user = new User();
        Person person = new Person();

        BeanUtils.copyProperties(account,user);
        BeanUtils.copyProperties(account,person);

        userService.insert(user);
        accountExService.insert(account);

        String str = "";
        for(int i=0;i<100;i++){
            str+=i;
        }

        person.setPhone(str);
        personService.insert(person);

    }
}
