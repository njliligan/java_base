package com.njganlili.model.singleton;

//基于枚举的饿汉模式
public enum Seven {

    INSTANCE;

    public Seven getInstance(){
        return INSTANCE;
    }


}
