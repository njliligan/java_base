package com.njganlili.inner;

/**
 * @author njgan
 * @description 静态内部类无法访问外部类的非static成员。
 * @date 2022/2/25 12:42
 */

class StaticHello{
    int x = 1;
    static class InnerClass{
        int y = 9;
    }
}

public class StaticInnerClass {

    public static void main(String[] args){
        StaticHello hello = new StaticHello();
        StaticHello.InnerClass innerClass = new StaticHello.InnerClass();
        System.out.println(hello.x + innerClass.y);
    }

}
