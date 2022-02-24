package com.njganlili.reflection;

import java.lang.reflect.InvocationTargetException;

/**
 * @author njgan
 * @description
 * @date 2022/2/16 10:57
 */
public class ReflectName {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 下面这段代码是以反射机制的方式创建对象。

        // 通过反射机制，获取Class，通过Class来实例化对象
        Class c = Class.forName("com.njganlili.reflection.User");
        // newInstance() 这个方法会调用User这个类的无参数构造方法，完成对象的创建。
        // 重点是：newInstance()调用的是无参构造，必须保证无参构造是存在的！
        Object obj = c.getDeclaredConstructor().newInstance();
        //所以实际上都是通过类名
        Object obje = c.getDeclaredConstructor(int.class,int.class).newInstance();
        System.out.println(obj);
    }
    //如果你只是希望一个类的静态代码块执行，其它代码一律不执行，可以使用
    //这个方法的执行会导致类加载，类加载时，静态代码块执行。

}
