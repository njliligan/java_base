package com.njganlili.parent.normal;

/**
 * @author njgan
 * @description
 * @date 2022/2/14 14:00
 */

public class Parent{

    Parent() {
        //   System.out.println(static_data);
        System.out.println("调用父类的构造函数");
    }
    void f() {
        System.out.println("执行父类f()方法");
    }

    void p(){
        System.out.println("执行父类p()方法");
    }

}
