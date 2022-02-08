package com.njganlili.juc;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

//信号灯,限流
public class SemaphoreTest {
    public static void main(String[] args) {


        //参错允许多少个同时执行
        Semaphore semaphore = new Semaphore(1);
        new Thread(()->{
            try {
                //阻塞方法，相当于得到许可
                semaphore.acquire();
                System.out.println("T1,Running.....");
                Thread.sleep(1000);
                System.out.println("T1,Running.....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }).start();

        new Thread(()->{
            try {
                //阻塞方法
                semaphore.acquire();
                System.out.println("T2,Running.....");
                Thread.sleep(1000);
                System.out.println("T2,Running.....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }).start();


    }

}
