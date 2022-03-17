package com.njganlili.juc.atomicInteger;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author njgan
 * @description
 * @date 2022/3/16 10:51
 */
public class AtomicIntegerTest {
    public static final int THREAD_NUMBER = 20;
    public static AtomicInteger count = new AtomicInteger(0);
    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUMBER);
    public static void increase() {
        count.getAndIncrement();
    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREAD_NUMBER; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    increase();
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(count);
    }
}
