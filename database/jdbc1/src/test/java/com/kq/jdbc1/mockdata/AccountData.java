package com.kq.jdbc1.mockdata;

import com.kq.jdbc1.entity.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * AccountData
 *
 * @author kq
 * @date 2019-11-20
 */
public class AccountData {

    public static List<Account> getAccountList(){
        List<Account> accountList = new ArrayList<>();
        Account account = new Account();
        account.setUsername("king");

        Account account1 = new Account();
        account1.setUsername("root");

        accountList.add(account);
        accountList.add(account1);

        return accountList;
    }

}
