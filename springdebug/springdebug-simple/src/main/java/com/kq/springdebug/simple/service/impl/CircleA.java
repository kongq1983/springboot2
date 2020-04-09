package com.kq.springdebug.simple.service.impl;


import com.kq.springdebug.simple.service.ICircleA;
import com.kq.springdebug.simple.service.ICircleB;
import com.kq.springdebug.simple.service.ICircleC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CircleA
 *
 * @author kq
 * @date 2019-11-27
 */
@Service
public class CircleA implements ICircleA {


    @Autowired
//    @Lazy
    private ICircleB circleB;

    @Autowired
    private ICircleC circleC;

    @Override
    public void show() {
        System.out.println("CircleA show()");
        circleC.show();
    }

    @Override
    public void showB() {
        if(circleB!=null)circleB.show();
    }
}
