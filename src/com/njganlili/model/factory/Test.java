package com.njganlili.model.factory;

/**
 * @author njgan
 * @description
 * @date 2022/3/12 12:27
 */
public class Test {

    public static void main(String[] args){
        Factory factory = new Factory();
        Behavior behavior = factory.getBehavior("fish");
        behavior.move();
    }

}
