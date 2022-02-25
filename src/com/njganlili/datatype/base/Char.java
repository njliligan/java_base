package com.njganlili.datatype.base;

/**
 * char为什么6535也有缓存？？
 */
public class Char {

    public static void main(String[] args){
        //65535
        char a = 65535;
        char b = 65535;
        char c = 127;
        char d = 127;
        System.out.println(a == b);
        System.out.println(c == d);
    }

}
