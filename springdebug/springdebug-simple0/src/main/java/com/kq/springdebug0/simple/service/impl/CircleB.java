package com.kq.springdebug0.simple.service.impl;


import com.kq.springdebug0.simple.service.ICircleA;
import com.kq.springdebug0.simple.service.ICircleB;
import com.kq.springdebug0.simple.service.ScopeA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CircleB
 *
 * @author kq
 * @date 2019-11-27
 */
@Service
public class CircleB implements ICircleB {

    //    @Lazy
    @Autowired
    private ICircleA circleA;

    @Autowired
    private ScopeA scopeA;


    @Override
    public void show() {
        System.out.println("CircleB show()");
        System.out.println("======== CircleB scopeA = "+scopeA);
    }

    @Override
    public void showA() {
        circleA.show();
    }


}
