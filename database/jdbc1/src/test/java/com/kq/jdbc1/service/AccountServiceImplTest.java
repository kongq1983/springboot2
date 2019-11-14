package com.kq.jdbc1.service;

import com.kq.jdbc1.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AccountServiceImplTest
 *
 * @author kq
 * @date 2019-11-08
 */
@Slf4j
public class AccountServiceImplTest extends BaseTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void update(){

        try{
            accountService.updateName(1l,"");
        }catch (Exception e) {
            log.error("数据操作报错!",e);
        }

        log.info("The End------------------------------");
    }

}
