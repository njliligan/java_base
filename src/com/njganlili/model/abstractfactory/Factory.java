package com.njganlili.model.abstractfactory;

/**
 * @author njgan
 * @description
 * @date 2022/3/12 12:59
 */
public class Factory {

    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("sex")){
            return new SexFactory();
        } else if(choice.equalsIgnoreCase("behavior")){
            return new BehaviorFactory();
        }
        return null;
    }

}
