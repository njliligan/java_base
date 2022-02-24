package com.njganlili.model.singleton;

public class First {

    private First() {
    }

    private static First first = new First();

    public static First getFirst() {
        return first;
    }

    public static void print(){
        System.out.println("第一个简单的单例");
    }

}
