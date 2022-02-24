package com.njganlili.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author njgan
 * @description 取得所有的属性。
 * @date 2022/2/16 11:01
 */
public class ReflectField {

    public static void main(String[] args) throws ClassNotFoundException {
        StringBuilder s = new StringBuilder();

        Class studentClass = Class.forName("com.njganlili.model.User");
        s.append(Modifier.toString(studentClass.getModifiers()) + " class " + studentClass.getSimpleName() + " {\n");// Class类的getName方法
        //获取所有的属性
        Field[] fields = studentClass.getDeclaredFields();
        for (Field f : fields){
            s.append("\t");
            // 获取属性的修饰符列表,返回的修饰符是一个数字，每个数字是修饰符的代号
            // 用Modifier类的toString转换成字符串
            s.append(Modifier.toString(f.getModifiers()));
            if (f.getModifiers() != 0) s.append(" ");
            s.append(f.getType().getSimpleName());// 获取属性的类型
            s.append(" ");
            s.append(f.getName());// 获取属性的名字
            s.append(";\n");
        }
        s.append("}");
        System.out.println(s);
    }
}
