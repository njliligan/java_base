package com.njganlili.juc.thread;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * @author njgan
 * @description
 * @date 2022/2/22 11:09
 */
public class ThreadPool {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            int a = 1;
            System.out.println("执行ing..............");
        };
        //内部只有一个核心线程，定时任务
        // 以无界队列方式来执行该线程，这使得这些任务之间不需要处理线程同步的问题，
        // 它确保所有的任务都在同一个线程中按顺序中执行，并且可以在任意给定的时间不会有多个线程是活动的。
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//        scheduledExecutorService.scheduleAtFixedRate(runnable,5,4,TimeUnit.SECONDS);

        //创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
        //这样的执行者适合于发起许多短命的任务的应用程序。
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(index);
                }
            });
        }
//        单线程化线程池
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        for (int i = 1; i < 10; i++) {
            final int index = i;
            executorService1.execute(() -> {
                //Thread.currentThread().setName("Thread i = " + index);
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                    System.out.println("eeeeeeeeeeeeeeeeeeeeee");
                } catch (InterruptedException e) {
                    System.out.println("ssss");
                }
            });
        }
            //该方法创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程，在需要时使用提供的 ThreadFactory 创建新线程
            ExecutorService executorService3 = Executors.newFixedThreadPool(10);
//        executorService.submit();
        executorService3.execute(()->{
            Arrays.asList("a","b","c").forEach(System.out::println);
        });

        //支持定时与周期性任务的线程池
        ScheduledExecutorService scheduledExecutorService1 = Executors.newScheduledThreadPool(10);

        //Java 8 新增创建线程池的方法，创建时如果不设置任何参数，则以当前机器处理器个数作为线程个数，此线程池会并行处理任务，不能保证执行顺序
        //顾名思义，它是基于 work-stealing 算法的，其中一个任务可以产生其他较小的任务，这些任务被添加到并行处理线程的队列中。如果一个线程完成了工作并且无事可做，则可以从另一线程的队列中"窃取"工作。
        //此外，此新池在何时使用ExecutorService和何时使用ForkJoinPool上又增加了一个灰色区域。现在，它们都具有这一共同的工作窃取原则作为其骨干，并且都可以用来优化大型计算递归任务。
        ExecutorService executorService4 = Executors.newWorkStealingPool();

        Long start = System.currentTimeMillis();

        for (int i =0;i< 10 ;i++){
            final int ideax = i;
            executorService4.execute(()->{
                try {
                    System.out.println("-----------------------");
                    Thread.sleep(ideax*1000);
                    System.out.println(ideax);
                    System.out.println();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        System.out.println("0---------------------");
        System.out.println("------------------------------------------------"+((System.currentTimeMillis()-start)/1000)+"--------------------------------------------------------");

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                20,
                1000,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
    }

}
