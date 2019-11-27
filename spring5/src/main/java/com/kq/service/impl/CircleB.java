package com.kq.service.impl;

import com.kq.service.ICircleA;
import com.kq.service.ICircleB;
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
