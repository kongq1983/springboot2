package com.kq.springdebug.simple2.service.impl;



import com.kq.springdebug.simple2.service.ICircleA;
import com.kq.springdebug.simple2.service.ICircleB;
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



    @Override
    public void show() {
        System.out.println("CircleA show()");
    }

    @Override
    public void showB() {
        if(circleB!=null)circleB.show();
    }
}
