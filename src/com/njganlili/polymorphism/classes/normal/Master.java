package com.njganlili.polymorphism.classes.normal;

/**
 * @author njgan
 * @description
 * @date 2022/2/14 20:20
 */
public class Master {

    public static void main(String[] args){
        Child son = new Child();
        son.f();
        son.p();
        son.g();
//        son.g();
    }

}
