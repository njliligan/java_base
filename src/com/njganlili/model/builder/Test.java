package com.njganlili.model.builder;

/**
 * @author njgan
 * @description
 * @date 2022/3/12 21:13
 */
public class Test {

    public  static void main(String[] args){
        Builder builder = new Builder();
        Human human =  builder.getHuman();
        Seaweed seaweed = builder.getSeaweed();
        System.out.println(human.behavior());
        System.out.println(human.name());
        System.out.println(human.environment().getEnvironment());
        System.out.println("-------------------------------------");
        System.out.println(seaweed.behavior());
        System.out.println(seaweed.name());
        System.out.println(seaweed.environment().getEnvironment());
    }

}
