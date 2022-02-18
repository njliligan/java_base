package com.njganlili.callback.tea.futrue.join;

/**
 * @author njgan
 * @description
 * @date 2022/2/18 11:40
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new TeaAndHotWaterThread.HotWaterThread();
        Thread t2= new TeaAndHotWaterThread.TeaThread();
//        t1.start();
//        t1.join();
//        t2.start();
//        t2.join();

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
