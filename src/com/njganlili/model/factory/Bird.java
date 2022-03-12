package com.njganlili.model.factory;

/**
 * @author njgan
 * @description
 * @date 2022/3/12 12:26
 */
public class Bird implements Behavior {
    @Override
    public void move() {
        System.out.println("天上飞");
    }
}
