package com.njganlili.model.builder;

/**
 * @author njgan
 * @description
 * @date 2022/3/12 20:53
 */
public abstract class LandAnimal implements Animal{

    @Override
    public abstract String behavior();

    @Override
    public Environment environment() {
        return new Land();
    }

}
