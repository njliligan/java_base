package com.njganlili.callback.tea.futrue.future;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author njgan
 * @description
 * @date 2022/2/18 15:01
 */
//阻塞式回调
public class Test {

    public static void main(String[] args) {
        Callable<Boolean> hotWaterJob = new Water();
        FutureTask<Boolean> hotWaterTask = new FutureTask<>(hotWaterJob);
        Thread hotWaterThread = new Thread(hotWaterTask, "烧水线程");

        Callable<Boolean> washJob = new Tea();
        FutureTask<Boolean> washTask = new FutureTask<>(washJob);
        Thread washThread = new Thread(washTask, "清洗线程");

        hotWaterThread.start();
        washThread.start();

        try {
            Long timestamp = System.currentTimeMillis();
            Boolean washFlag = washTask.get();
            Boolean hotWaterFlag = hotWaterTask.get();
            System.out.println(System.currentTimeMillis() - timestamp);

            drinkTea(hotWaterFlag, washFlag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void drinkTea(Boolean hotWaterFlag, Boolean washFlag) {
        if (hotWaterFlag && washFlag) {
            System.out.println("喝茶");
        }
    }

}
