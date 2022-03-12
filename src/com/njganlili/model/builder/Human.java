package com.njganlili.model.builder;

/**
 * @author njgan
 * @description
 * @date 2022/3/12 20:55
 */
public class Human extends LandAnimal{
    @Override
    public String name() {
        return "human";
    }

    @Override
    public String behavior() {
        return "walk";
    }
}
