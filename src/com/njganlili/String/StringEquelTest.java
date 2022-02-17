package com.njganlili.String;

/**
 * @author njgan
 * @description
 * @date 2022/2/17 11:03
 */
public class StringEquelTest {

    public static void main(String[] args){

        //直接被编译器优化掉了
        if ("a" == "a"){
            System.out.println("a");
        }

        //没有编译掉
        if (new String("a") == new String("a")){
            System.out.println("a2");
        }
    }

}
