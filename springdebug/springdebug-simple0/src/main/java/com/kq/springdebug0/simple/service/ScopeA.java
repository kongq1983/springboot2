package com.kq.springdebug0.simple.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2021-05-12 13:49
 * @since 2020-0630
 */

@Scope("prototype")
@Component
public class ScopeA {

    public void scope(){
        System.out.println("ScopeA");
    }

}
