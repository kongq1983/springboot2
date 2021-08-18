package com.kq.hikaricp.service;

import com.kq.entity.Account;

/**
 * @author kq
 * @date 2021-05-18 10:09
 * @since 2020-0630
 */
public interface AccountXmlService {

    public void addAccount(Account account) ;

    public void deadlock(Long id);

}
