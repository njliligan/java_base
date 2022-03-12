package com.njganlili.model.builder;

/**
 * @author njgan
 * @description
 * @date 2022/3/12 21:01
 */
public class Lion extends LandAnimal {
    @Override
    public String name() {
        return "lion";
    }

    @Override
    public String behavior() {
        return "run";
    }
}
