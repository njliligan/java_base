package com.njganlili.model.builder;

/**
 * @author njgan
 * @description
 * @date 2022/3/12 21:02
 */
public class Whale extends OceanAnimal{
    @Override
    public String name() {
        return "whale";
    }

    @Override
    public String behavior() {
        return "swim";
    }
}
