package com.njganlili.fild;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * @author njgan
 * @description
 * @date 2022/2/16 11:37
 */
public class ReflectConstructor {

    /*
反编译一个类的Constructor构造方法。
 */
        public static void main(String[] args) throws ClassNotFoundException {
            StringBuilder s = new StringBuilder();

            Class vipClass = Class.forName("com.njganlili.fild.User");

            //public class UserService {
            s.append(Modifier.toString(vipClass.getModifiers()));
            s.append(" class ");
            s.append(vipClass.getSimpleName());
            s.append("{\n");

            Constructor[] constructors = vipClass.getDeclaredConstructors();
            for (Constructor c : constructors){
                //public Vip(int no, String name, String birth, boolean sex) {
                s.append("\t");
                s.append(Modifier.toString(c.getModifiers()));
                s.append(" ");
//            s.append(c.getName());//包名+类名
                s.append(vipClass.getSimpleName());//类名
                s.append("(");
                Class[] parameterTypes = c.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++){
                    s.append(parameterTypes[i].getSimpleName());
                    if (i != parameterTypes.length - 1 ) s.append(", ");
                }
                s.append("){}\n");
            }

            s.append("}");
            System.out.println(s);
        }
}
