package com.njganlili.reflection;

import com.njganlili.model.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author njgan
 * @description
 * @date 2022/2/16 11:06
 */
public class SetValue {

    /*
    必须掌握：
    怎么通过反射机制访问一个java对象的属性？
    给属性赋值set
    获取属性的值get
     */
        public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
            //不使用反射机制给属性赋值
            User student = new User();
            /**给属性赋值三要素：给s对象的no属性赋值1111
             * 要素1：对象s
             * 要素2：no属性
             * 要素3：1111
             */
            student.setId("1111");
            /**读属性值两个要素：获取s对象的no属性的值。
             * 要素1：对象s
             * 要素2：no属性
             */
            System.out.println(student.getId());

            //使用反射机制给属性赋值
            Class userClass = Class.forName("com.njganlili.model.User");
            Object obj = userClass.getDeclaredConstructor().newInstance();// obj就是Student对象。（底层调用无参数构造方法）

            // 获取no属性（根据属性的名称来获取Field）
            Field noField = userClass.getDeclaredField("id");
            // 给obj对象(Student对象)的no属性赋值
        /*
            虽然使用了反射机制，但是三要素还是缺一不可：
                要素1：obj对象
                要素2：no属性
                要素3：22222值
            注意：反射机制让代码复杂了，但是为了一个“灵活”，这也是值得的。
         */
            //设置private类型可修改
            noField.setAccessible(true);
            noField.set(obj, "22222");

            User user = (User) obj;
            System.out.println(user.getId());

            // 读取属性的值
            // 两个要素：获取obj对象的no属性的值。
            System.out.println(noField.get(obj));


        }


    }
