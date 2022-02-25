package com.njganlili.inner;

/**
 * @author njgan
 * @description 内部类私有，无法访问。
 * @date 2022/2/25 12:40
 */
class PrivateHello{
    int x = 1;
    private class InnerClass{
        int y = 9;
    }
}


public class PrivateInnerClass {

    public static void main(String[] args){
        PrivateHello hello = new PrivateHello();
        //Hello.InnerClass innerClass = hello.new InnerClass();
        //System.out.println(hello.x + innerClass.y);
    }


}
