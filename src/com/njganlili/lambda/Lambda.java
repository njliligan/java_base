package com.njganlili.lambda;

/**
 * @author njgan
 * @description 使用lamda的要求就是
 * @date 2022/2/13 9:43
 */
public class Lambda {

    //1. 使用Lambda必须具有接口，且要求接口中有且仅有一个抽象方法。无论是JDK内置的 Runnable 、 Comparator 接口还是自定义的接口，
    // 只有当接口中的抽象方法存在且唯一时，才可以使用Lambda。
    //2. 使用Lambda必须具有上下文推断。也就是方法的参数或局部变量类型必须为Lambda对应的接口类型，才能使用Lambda作为该接口的实例。
    //————————————————
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
