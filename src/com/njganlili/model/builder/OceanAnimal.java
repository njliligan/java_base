package com.njganlili.model.builder;

/**
 * @author njgan
 * @description
 * @date 2022/3/12 20:39
 */
public abstract class OceanAnimal implements Animal {

    @Override
    public abstract String behavior();

    @Override
    public Environment environment() {
        return new Ocean();
    }

}
