package com.kq.batch.service.impl;

import com.kq.batch.mapper.AccountMapper;
import com.kq.batch.service.AccountService;
import com.kq.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void insertList(List<Account> list) {

        if(list==null) return;

        for(Account account : list) {
            accountMapper.addAccountNoId(account);
        }


    }

    @Transactional
    public void insertTest(int size) {

        Date date = new Date();
        long startTime = System.currentTimeMillis();
        for(long i=1;i<size;i++) {
            Account account = new Account();
            account.setId(i);
            account.setUsername("test"+i);
            account.setCreateTime(date);
            accountMapper.addAccountId(account);
        }
        long endTime = System.currentTimeMillis();

        log.info("插入{}条数据，花费{}ms",size,(endTime-startTime));
        String str = "插入%s条数据，花费%sms";
        System.out.printf(str,size+"",(endTime-startTime)+"");
    }

}
