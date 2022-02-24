package com.njganlili.polymorphism.classes.constract;

/**
 * @author njgan
 * @description 父类有参构造器须在子类构造器的第一行
 * @date 2022/2/14 20:20
 */
public class Master {

    public static void main(String[] args){
        Parent child = new Child();
        Child child2 = (Child) child;
        child2.f();
        child2.g();
        child2.p();
//        son.g();
        Child child1 = new Child("miky","18","M");
        System.out.println(child1.toString());
    }

}
