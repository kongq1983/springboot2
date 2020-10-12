package com.kq.aop.minial.pojo;

/**
 * @author kq
 * @date 2020-10-12 16:02
 * @since 2020-0630
 */
public class SimplePojo implements Pojo{

    public void foo() {
        System.out.println("foo is call");
        // this next method invocation is a direct call on the 'this' reference
        this.bar();
    }

    public void bar() {
        // some logic...
        System.out.println("bar is call");
    }

}
