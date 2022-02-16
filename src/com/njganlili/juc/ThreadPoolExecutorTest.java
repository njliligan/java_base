package com.njganlili.juc;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author njgan
 * @description
 * @date 2022/2/15 18:26
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args){

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,20,6,TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>(),new ThreadPoolExecutor.CallerRunsPolicy());
//      ScheduledThreadPoolExecutor
//      ForkJoinPool
    }

}
