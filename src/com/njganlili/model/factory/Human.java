package com.njganlili.model.factory;

/**
 * @author njgan
 * @description
 * @date 2022/3/12 12:27
 */
public class Human implements Behavior {
    @Override
    public void move() {
        System.out.println("地上走");
    }
}
