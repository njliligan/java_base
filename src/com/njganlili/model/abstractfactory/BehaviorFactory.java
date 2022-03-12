package com.njganlili.model.abstractfactory;

import com.njganlili.model.factory.Behavior;
import com.njganlili.model.factory.Bird;
import com.njganlili.model.factory.Fish;
import com.njganlili.model.factory.Human;

/**
 * @author njgan
 * @description
 * @date 2022/3/12 12:57
 */
public class BehaviorFactory extends AbstractFactory{
    @Override
    public Behavior getBehavior(String kind) {
        Behavior behavior;
        switch (kind){
            case "bird": behavior = new Bird(); break;
            case "fish": behavior = new Fish(); break;
            case "human": behavior = new Human(); break;
            default: behavior = new Human();
        }
        return behavior;
    }

    @Override
    public Sex getSex(String sex) {
        return null;
    }
}
