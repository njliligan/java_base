package com.njganlili.callback.teacherandstudent;

/**
 * @author njgan
 * @description
 * @date 2022/2/17 20:45
 */
/** 2 * 回调测试，原文出处http://www.cnblogs.com/xrq730/p/6424471.html 3
 * @author njgan*/
public class CallbackTest {

    public static void main(String[] args) {
        Student student = new Rick();
        Teacher teacher = new Teacher(student);
        new Runnable(){
            @Override
            public void run() {

            }
        };
        Runnable runnable =
                () -> {
                    System.out.println("run");
                };
        teacher.askQuestion();
    }
}
