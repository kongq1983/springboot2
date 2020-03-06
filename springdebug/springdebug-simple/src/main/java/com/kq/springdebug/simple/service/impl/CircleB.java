package com.kq.springdebug.simple.service.impl;


import com.kq.springdebug.simple.service.ICircleA;
import com.kq.springdebug.simple.service.ICircleB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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

    @Override
    public void show() {
        System.out.println("CircleB show()");
    }

    @Override
    public void showA() {
        circleA.show();
    }
}
