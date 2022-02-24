package com.njganlili.polymorphism.classes.normal;

/**
 * @author njgan
 * @description
 * @date 2022/2/14 20:17
 */


public class Child extends Parent {
    Child() {
        System.out.println("调用子类的构造函数");
    }
    @Override
    void f(){
        System.out.println("执行子类中的f()方法");

    }

    void g() {
        System.out.println("执行子类的g()方法");

    }

}
