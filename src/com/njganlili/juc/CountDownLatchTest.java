package com.njganlili.juc;

import java.util.concurrent.CountDownLatch;

//倒计时达到就放
public class CountDownLatchTest {
    public static void main(String[] args) {
        Thread[] threads =new Thread[100];

        CountDownLatch countDownLatch = new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
               int result = 0;
               for (int j= 0 ;j<10000;j++){
                   result += j;
               }
               countDownLatch.countDown();
            });
        }
        for (int i=0;i< threads.length;i++){
            threads[i].start();
        }
        try{
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end latch");
    }
}
