package com.njganlili.inner;

/**
 * @author njgan
 * @description
 * @date 2022/2/15 15:50
 */
abstract interface Person{
    public abstract void eat();
}

public class NoNameInnerClass {

    public static void main(String[] args){
        Person person = () ->{
            System.out.println("这是匿名内部类");
        };
        person.eat();
    }

}
