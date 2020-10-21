package com.kq.springdebug.simple.service.impl;

import com.kq.springdebug.simple.service.ICircleA;

/**
 * @author kq
 * @date 2020-10-20 19:12
 * @since 2020-0630
 */
public class CircleAWrapper implements ICircleA {

    ICircleA circleA;

    public CircleAWrapper(ICircleA circleA){
        this.circleA = circleA;
    }

    @Override
    public void show() {
        circleA.show();
    }

    @Override
    public void showB() {
        circleA.showB();
    }

    @Override
    public String toString() {
        return "CircleAWrapper{" +
                "circleA=" + circleA +
                '}';
    }
}
