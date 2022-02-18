package com.njganlili.callback.tea.futrue;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author njgan
 * @description
 * @date 2022/2/18 11:33
 */
public class FutureAndCallback {

    private static final Callable<String> callable1 = () -> {
        Thread.sleep(3000L); // 模拟烧水动作
        System.out.println("烧开水成功");
        return "hot_water";
    };

    private static final FutureTask<String> ft1 = new FutureTask<>(callable1);

    private static final Callable<String> callable2 = () -> {
        if (ft1.get().equals("hot_water")) {
            Thread.sleep(1000L); // 模拟泡茶动作
            System.out.println("泡茶成功");
            return "tea is done";
        } else {
            return "tea is not done";
        }
    };
    private static final FutureTask<String> ft2 = new FutureTask<>(callable2);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        new Thread(ft1).start();
        new Thread(ft2).start();
        System.out.println(ft2.get());
    }
}
