package com.njganlili.model.abstractfactory;

import com.njganlili.model.factory.Behavior;

/**
 * @author njgan
 * @description
 * @date 2022/3/12 13:02
 */
public class test {

    public static void main(String[] args){
        //取得性别的工厂
        AbstractFactory abstractFactory = Factory.getFactory("sex");
        Sex man = abstractFactory.getSex("man");
        man.sex();

        AbstractFactory abstractFactory1 = Factory.getFactory("behavior");
        Behavior fish = abstractFactory1.getBehavior("fish");
        fish.move();
    }

}
