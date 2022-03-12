package com.njganlili.model.builder;

/**
 * @author njgan
 * @description
 * @date 2022/3/12 21:03
 */
public class Seaweed extends OceanAnimal{
    @Override
    public String name() {
        return "seaweed";
    }

    @Override
    public String behavior() {
        return "floating";
    }
}
