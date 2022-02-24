package com.njganlili.juc.callback.tea.futrue.future;

import java.util.concurrent.Callable;

/**
 * @author njgan
 * @description
 * @date 2022/2/18 14:19
 */
public class Tea implements Callable<Boolean>{

    @Override
    public Boolean call() throws Exception {
        try {
            Thread.currentThread().setName("清洗线程");
            System.out.println("洗茶壶");
            System.out.println("洗茶杯");
            System.out.println("拿茶叶");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("洗茶叶完成");
        return true;
    }
}
