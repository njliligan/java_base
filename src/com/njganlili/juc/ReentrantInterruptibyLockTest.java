package com.njganlili.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantInterruptibyLockTest {


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread t1 = new Thread(()->{
            try {
                System.out.println("T1 begain");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                lock.lockInterruptibly();
                System.out.println("T2 begain");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+"interrupted");
            }finally {
                try{
                    lock.unlock();
                }catch (Exception exception){
                    System.out.println("线程中断结束");
                }

            }
        });
        t1.start();
        t2.start();
        t2.interrupt();
        if(t2.isInterrupted()){
            System.out.println("线程中断");
        };

    }

}
