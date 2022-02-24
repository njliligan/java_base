package com.njganlili.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author njgan
 * @description
 * @date 2022/2/21 21:36
 */
public class ObjectTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        User user = new User();
        user.setNo(10);
        Object object = user;
        Class classs = object.getClass();
        Field a = classs.getDeclaredField("no");
        System.out.println(object);
        Method method = classs.getDeclaredMethod("getNo");
        Method[] methods = classs.getDeclaredMethods();
        for (Method me: methods
             ) {
            System.out.println(me.getName());
        }
        System.out.println(method.invoke(object));;
    }

}
