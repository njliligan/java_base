package com.njganlili.juc;

public class SynchronizedTest {

    static int count;

    public static void main(String[] args) {
        //SyncThread syncThread = new SyncThread();
        //Thread thread1 = new Thread(syncThread, "SyncThread1");
        //Thread thread2 = new Thread(syncThread, "SyncThread2");

        SyncThread syncThread = new SyncThread();
        Thread thread1 = new Thread(new SyncThread(), "SyncThread1");
        Thread thread2 = new Thread(new SyncThread(), "SyncThread2");

        thread1.start();
        thread2.start();
    }

}

class SyncThread implements Runnable {
    private static int count;

    public SyncThread() {
        count = 0;
    }

    public static void method2(){
        for (int i = 0; i < 5; i ++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //静态方法属于类，所以是对这个类加了同一把锁
    public synchronized static void method() {
        for (int i = 0; i < 5; i ++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //属于对象的，如果new新的就没用了
    @Override
    public synchronized void run() {
        method();
        //method2();
    }

}
