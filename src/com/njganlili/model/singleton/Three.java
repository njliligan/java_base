package com.njganlili.model.singleton;

//单例模式第三版（线程安全的懒汉模式）
public class Three {

    private static Three three;

    private Three() {
    }

    public static synchronized Three getThree(){
        if(three == null){
            three = new Three();
        }
        return three;
    }

}
