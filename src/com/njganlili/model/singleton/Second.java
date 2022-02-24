package com.njganlili.model.singleton;

public class Second {

    private static Second second;

    private Second() {
    }

    public static Second getSecond(){
        if(second == null){
            second = new Second();
        }
        return second;
    }

    public static void print(){
        System.out.println("这是一个单例模式");
    }

}
