package com.njganlili.inner;

/**
 * @author njgan
 * @description
 * 由于内部类嵌套在外部类中，因此必须首先实例化外部类，然后创建内部类的对象来实现。
 * 成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）
 * 不过要注意的是，当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，即默认情况下访问的是成员内部类的成员。如果要访问外部类的同名成员，需要以下面的形式进行访问
 * 外部类.this.成员变量
 * 外部类.this.成员方法
 *
 * @date 2022/2/25 11:41
 */
class Hello{
    int x = 1;
    class InnerClass{
        int y = 9;
    }
}


public class InnerClass {

    public static void main(String[] args){
        Hello hello = new Hello();
        Hello.InnerClass innerClass = hello.new InnerClass();
        System.out.println(hello.x + innerClass.y);
    }


}
