package com.njganlili.juc.lock;

import java.util.concurrent.locks.ReentrantLock;

//公平锁，重入的互斥锁
public class ReentrantLockFairTest extends Thread {
    ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获得锁" + "------------" + i);
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockFairTest reentrantLock_fair_test = new ReentrantLockFairTest();
        Thread thread1 = new Thread(reentrantLock_fair_test);
        Thread thread2 = new Thread(reentrantLock_fair_test);
        thread1.start();
        thread2.start();
    }


}
