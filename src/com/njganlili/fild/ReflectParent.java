package com.njganlili.fild;

/**
 * @author njgan
 * @description
 * @date 2022/2/16 14:02
 */
public class ReflectParent {
    public static void main(String[] args) throws ClassNotFoundException {
        Class string = Class.forName("java.lang.String");
        Class parent = string.getSuperclass();
        Class[] interfaces = string.getInterfaces();
        System.out.println("继承的父类是："+parent.getName());
        for (Class i : interfaces) {
            System.out.println("实现的接口有："+i.getName());
        }
    }
}
