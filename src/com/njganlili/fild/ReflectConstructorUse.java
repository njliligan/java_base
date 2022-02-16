package com.njganlili.fild;

import java.lang.reflect.Constructor;

/**
 * @author njgan
 * @description
 * @date 2022/2/16 11:40
 */
public class ReflectConstructorUse {

    /*
比上一个例子(ReflectTest11)重要一些！！！

通过反射机制调用构造方法实例化java对象。（这个不是重点）
 */
        public static void main(String[] args) throws Exception {
            //不适用反射创建对象
            User user1 = new User();
            User user2 = new User(123,18);

            //使用反射机制创建对象（以前）
            Class userClass = Class.forName("com.njganlili.fild.User");
            // 调用无参数构造方法
            Object obj1 = userClass.getDeclaredConstructor().newInstance();//Class类的newInstance方法
            System.out.println(obj1);

            //使用反射机制创建对象（现在）
            // 调用有参数的构造方法怎么办？
            // 第一步：先获取到这个有参数的构造方法
            Constructor c1 = userClass.getDeclaredConstructor(int.class,int.class);
            // 第二步：调用构造方法new对象
            Object obj2 = c1.newInstance(32,19);//Constructor类的newInstance方法
            System.out.println(obj2);

            // 获取无参数构造方法
            Constructor c2 = userClass.getDeclaredConstructor();
            Object obj3 = c2.newInstance();
            System.out.println(obj3);
        }

}
