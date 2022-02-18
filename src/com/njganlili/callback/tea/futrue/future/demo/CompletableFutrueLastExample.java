package com.njganlili.callback.tea.futrue.future.demo;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @author njgan
 * @description
 * @date 2022/2/18 16:22
 */
public class CompletableFutrueLastExample {

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(14);
        double a = 0D;
        Long start = System.currentTimeMillis();
        List<CompletableFuture<Long>> futures = Arrays.asList(
                new DataHelper().getDate(countDownLatch),
                new DataHelper().getDate(countDownLatch),
                new DataHelper().getDate(countDownLatch),
                new DataHelper().getDate(countDownLatch),
                new DataHelper().getDate(countDownLatch),
                new DataHelper().getDate(countDownLatch),
                new DataHelper().getDate(countDownLatch),
                new DataHelper().getDate(countDownLatch),
                new DataHelper().getDate(countDownLatch),
                new DataHelper().getDate(countDownLatch),
                new DataHelper().getDate(countDownLatch),
                new DataHelper().getDate(countDownLatch),
                new DataHelper().getDate(countDownLatch),
                new DataHelper().getDate(countDownLatch));
        //countDownLatch.await();
        Long end = System.currentTimeMillis();
        float excTime = (float) (end - start) / 1000;
        System.out.println(excTime);
        //CompletableFuture.allOf(futures.toArray(new CompletableFuture<?>[0])).join();
        for (CompletableFuture<Long> c : futures
        ) {
            a = a + c.get();
        }
        System.out.println(a/1000);
    }

}
