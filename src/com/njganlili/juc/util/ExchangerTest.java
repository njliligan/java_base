package com.njganlili.juc.util;

import java.util.concurrent.Exchanger;

//交换数据，两个线程之间
public class ExchangerTest {

    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(()->{
            String s = "T1";
            try {
                //这个是阻塞的方法
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" "+s);
        },"t1").start();

        new Thread(()->{
            String s = "T2";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" "+s);
        },"t2").start();

//        new Thread(()->{
//            String s = "T3";
//            try {
//                s = exchanger.exchange(s);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+" "+s);
//        },"t3").start();

    }


}
