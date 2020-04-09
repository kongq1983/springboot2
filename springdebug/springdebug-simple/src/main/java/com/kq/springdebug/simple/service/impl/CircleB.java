package com.kq.springdebug.simple.service.impl;


import com.kq.springdebug.simple.service.ICircleA;
import com.kq.springdebug.simple.service.ICircleB;
import com.kq.springdebug.simple.service.ICircleC;
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

    private ICircleC circleC;

    @Override
    public void show() {
        System.out.println("CircleB show()");
        circleC.showC();
    }

    @Override
    public void showA() {
        circleA.show();
        circleC.showC();
    }

    @Autowired
    public void setCircleC(ICircleC circleC) {
        this.circleC = circleC;
    }



}
