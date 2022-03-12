package com.njganlili.model.factory;

/**
 * @author njgan
 * @description
 * @date 2022/3/12 12:25
 */
public class Fish implements Behavior {
    @Override
    public void move() {
        System.out.println("水里游");
    }
}
