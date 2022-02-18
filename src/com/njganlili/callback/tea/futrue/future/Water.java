package com.njganlili.callback.tea.futrue.future;

import java.util.concurrent.Callable;

/**
 * @author njgan
 * @description
 * @date 2022/2/18 14:19
 */
public class Water implements Callable<Boolean>{
    @Override
    public Boolean call() throws Exception {
        try {
            Thread.currentThread().setName("烧水线程");
            System.out.println("洗好水壶");
            System.out.println("灌好凉水");
            System.out.println("放在火上");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("水烧开了");
        return true;
    }

}
