package com.njganlili.juc;

import java.nio.FloatBuffer;
import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//非公平锁，重入的互斥锁
public class ReentrantLockTest {
    ReentrantLock lock = new ReentrantLock();

    void m1() {
        lock.lock();
        try {
            for (int a = 0; a < 6; a++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(a);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    void m2() {
        boolean locked = false;
        try {
            for (int i = 0; i < 5; i++) {
                locked = lock.tryLock(5, TimeUnit.SECONDS);
                System.out.println(locked);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        //是否是公平锁
        //ReentrantLock reentrantLock = new ReentrantLock(true);
        //
        new Thread(reentrantLockTest::m1).start();
        new Thread(reentrantLockTest::m2).start();

    }


}
