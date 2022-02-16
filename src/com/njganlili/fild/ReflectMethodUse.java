package com.njganlili.fild;


import java.lang.reflect.Method;

/**
 * @author njgan
 * @description
 * @date 2022/2/16 11:31
 */
public class ReflectMethodUse {

    public static void main(String[] args) throws Exception {
        // 不使用反射机制，怎么调用方法
        // 创建对象
        User user = new User();
        // 调用方法
        /*
            要素分析：
                要素1：对象userService
                要素2：login方法名
                要素3：实参列表
                要素4：返回值
         */
        //System.out.println(user.sout());

        //使用反射机制调用方法
        Class userClass = Class.forName("com.njganlili.fild.User");
        // 创建对象
        Object obj = userClass.getDeclaredConstructor().newInstance();
        // 获取Method
        Method sout = userClass.getDeclaredMethod("sout");
//        Method loginMethod = userServiceClass.getDeclaredMethod("login");//注：没有形参就不传
        // 调用方法
        // 调用方法有几个要素？ 也需要4要素。
        // 反射机制中最最最最最重要的一个方法，必须记住。
        /*
            四要素：
            loginMethod方法
            obj对象
            "admin","123" 实参
            retValue 返回值
         */
        Object resValues = sout.invoke(obj);//注：方法返回值是void 结果是null
        System.out.println(resValues);
    }

}
