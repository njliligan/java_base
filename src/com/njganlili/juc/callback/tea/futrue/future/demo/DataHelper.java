package com.njganlili.juc.callback.tea.futrue.future.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @author njgan
 * @description
 * @date 2022/2/18 16:31
 */
public class DataHelper {

    public  CompletableFuture getDate(CountDownLatch countDownLatch){
        return CompletableFuture.supplyAsync(() -> {
            try {
                long a =  new Double(Math.random()*(2000)).longValue();
                Thread.sleep(a);
                System.out.println(a);
                //
                countDownLatch.countDown();
                //System.out.println(countDownLatch.getCount());
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
