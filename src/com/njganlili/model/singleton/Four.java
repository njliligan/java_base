package com.njganlili.model.singleton;

//可能会发生重排序
public class Four {

    private static Four four;

    private Four() {
    }

    public static Four getFour() {
        //先检查一遍
        if (four == null){
            synchronized (Four.class){
                //在检查一遍
                if (four == null){
                    four = new Four();
                }
            }
        }
        return four;
    }
}
