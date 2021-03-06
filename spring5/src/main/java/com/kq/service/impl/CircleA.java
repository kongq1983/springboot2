package com.kq.service.impl;

import com.kq.service.ICircleA;
import com.kq.service.ICircleB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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

    @Override
    public void show() {
        System.out.println("CircleA show()");
    }

    @Override
    public void showB() {
        if(circleB!=null)circleB.show();
    }
}
