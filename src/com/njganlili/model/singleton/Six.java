package com.njganlili.model.singleton;

//单例模式第六版（基于第四版使用静态内部类解决重排序带来的问题）
public class Six {

    private static Six six;

    private Six() {
    }

    private static  class InnerSix{
        public static Six six =new Six();
    }

    public static Six getSix() {
        return InnerSix.six;
    }
}
