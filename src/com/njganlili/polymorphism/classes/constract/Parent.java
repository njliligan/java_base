package com.njganlili.polymorphism.classes.constract;

/**
 * @author njgan
 * @description
 * @date 2022/2/14 14:00
 */

public class Parent{

    protected String name = "parent";

    protected String age = "18";

    Parent() {
        //   System.out.println(static_data);
        System.out.println("调用父类的构造函数");
    }

    public static void parents(){
        System.out.println("parents");
    }

    public static void sss(){
        System.out.println("parent");
    }

    public Parent(String name, String age) {
        this.name = name;
        this.age = age;
    }

    void f() {
        System.out.println("执行父类f()方法");
    }

    void p(){
        System.out.println("执行父类p()方法");
    }

}
