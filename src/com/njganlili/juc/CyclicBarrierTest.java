package com.njganlili.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//循环栅栏，等到一定的线程数才能执行，可以循环
public class CyclicBarrierTest {

    public static void main(String[] args) {
        // write your code here
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello");
//            }
//        });
        //满了就放
        //线程数，执行的操作。
        CyclicBarrier cyclicBarrier = new CyclicBarrier(20,()->{
            System.out.println("hello");
        });
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    cyclicBarrier.await();
                    System.out.println("test");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
