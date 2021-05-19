package com.kq.hikaricp.service.impl;

import com.kq.entity.Account;
import com.kq.hikaricp.mapper.AccountXmlMapper;
import com.kq.hikaricp.service.AccountXmlService;
import com.zaxxer.hikari.pool.HikariPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kq
 * @date 2021-05-18 10:10
 * @since 2020-0630
 */
@Service
public class AccountXmlServiceImpl implements AccountXmlService {

    private final Logger logger = LoggerFactory.getLogger(AccountXmlServiceImpl.class);

    @Autowired
    private AccountXmlMapper accountXmlMapper;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private AtomicInteger dealTimes = new AtomicInteger(0);


    @Override
    public void addAccount(Account account) {

        Date date = new Date();

        for(int i=0;i<3;i++) {
            Account account1 = new Account();
            int index = atomicInteger.incrementAndGet();
            account1.setUsername("test"+index);
            account1.setCreateTime(date);
            account1.setProvince("zj");
            accountXmlMapper.addAccount(account1);
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void deadlock(Long id) {
        int times = dealTimes.incrementAndGet();
        logger.debug("start deadlock dealtimes = {}",times);
        accountXmlMapper.deadlock(id);
        logger.debug("e-n-d deadlock dealtimes = {}",times);
    }

}
