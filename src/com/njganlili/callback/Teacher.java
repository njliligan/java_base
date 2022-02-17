package com.njganlili.callback;

/**
 * @author njgan
 * @description
 * @date 2022/2/17 20:29
 */

//A类对象的方法a调用B类对象的方法b执行某些操作，在b执行过程中又会调用A类对象的方法c，这个A类对象的c方法即回调函数，
public class Teacher implements Answer {

    private Student student;

              public Teacher(Student student) {
                 this.student = student;
             }

             public void askQuestion() {
                 student.resolveQuestion(this);
             }

             @Override
             public void tellAnswer(int answer) {
                 System.out.println("知道了，你的答案是" + answer);
             }

}
