package com.njganlili.juc;

public class VolatileTest extends Thread{

    //不使用volatile修饰，进程不结束。
    //1）保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。 2）禁止进行指令重排序。
    private static volatile boolean flag = false;

    @Override
    public void run() {
        while (!flag) ;
    }

    public static void main(String[] args) throws Exception {
        new VolatileTest().start();
        Thread.sleep(2000);
        flag = true;
    }

}
