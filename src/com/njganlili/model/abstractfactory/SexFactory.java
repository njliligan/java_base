package com.njganlili.model.abstractfactory;

import com.njganlili.model.factory.Behavior;
import com.njganlili.model.factory.Bird;
import com.njganlili.model.factory.Fish;
import com.njganlili.model.factory.Human;

/**
 * @author njgan
 * @description
 * @date 2022/3/12 12:56
 */
public class SexFactory extends AbstractFactory{
    @Override
    public Behavior getBehavior(String behavior) {
        return null;
    }

    @Override
    public Sex getSex(String kind) {
        Sex sex;
        switch (kind){
            case "man": sex = new Man(); break;
            case "woman": sex = new Woman(); break;
            case "asexual": sex = new Asexual(); break;
            default: sex = new Asexual();
        }
        return sex;
    }

}
