package com.njganlili.model.factory;

/**
 * @author njgan
 * @description 工厂
 * @date 2022/3/12 12:28
 */
public class Factory {

    public Behavior getBehavior(String kind){
        Behavior behavior;
        switch (kind){
            case "bird": behavior = new Bird(); break;
            case "fish": behavior = new Fish(); break;
            case "human": behavior = new Human(); break;
            default: behavior = new Human();
        }
        return behavior;
    }

}
