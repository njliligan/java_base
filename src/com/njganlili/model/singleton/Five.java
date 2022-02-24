package com.njganlili.model.singleton;

public class Five {

    private Five() {
    }

    private volatile static Five five;

    public static Five getFive() {
        if (five == null){
            synchronized (Five.class){
                if (five == null){
                    five =new Five();
                }
            }
        }
        return five;
    }
}
