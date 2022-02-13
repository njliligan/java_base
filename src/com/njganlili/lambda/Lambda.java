package com.njganlili.lambda;

/**
 * @author njgan
 * @description
 * @date 2022/2/13 9:43
 */
public class Lambda {

    public static void main(String[] args){
        //无参lambda
        Runnable runnable1 = ()->{
            System.out.println("无参lambda");
        };
        //多个参数的lambda
//        Runnable runnable2 = (x,y)->{
//            System.out.println("有参lambda");
//        };
        //单个参数的lambda，括号可以省略
//        Runnable runnable3 = x->{
//            System.out.println("有参lambda");
//        };
    }

}
