package com.njganlili.packageType;

/**
 * @author njgan
 * @description
 * @date 2022/2/23 14:27
 */
public class packageType {

    public static void main(String[] args){
        //-128到127在静态常量池，所以a==b
        Integer a = 100;
        Integer b = 100;
        Integer c = 128;
        Integer d = 128;
        System.out.println(a == b );
        System.out.println(c == d );
    }

}
