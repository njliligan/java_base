package com.njganlili.juc.callback.tea.futrue.future;

/**
 * @author njgan
 * @description
 * @date 2022/2/18 14:30
 */

import java.util.concurrent.*;

/**
 * JDK CompletableFuture异步回调测试
 *
 */
public class JdkCompletableFutureTest {

    public static void main(String[] args) throws Exception {
        ExecutorService executor =  new ThreadPoolExecutor(
                //核心线程数，它的数量决定了添加的任务是开辟新的线程去执行，还是放到workQueue任务队列中去
                4,
                //指定了线程池中的最大线程数量，这个参数会根据你使用的workQueue任务队列的类型，决定线程池会开辟的最大线程数量
                20,
                //当线程池中空闲线程数量超过corePoolSize时，多余的线程会在多长时间内被销毁
                1000,
                //
                TimeUnit.SECONDS,
                //任务队列，被添加到线程池中，但尚未被执行的任务；它一般分为直接提交队列、有界任务队列、无界任务队列、优先任务队列几种
                new LinkedBlockingQueue<Runnable>(),
                //线程工厂，用于创建线程，一般用默认即可
                new ThreadPoolExecutor.CallerRunsPolicy()
                //拒绝策略；当任务太多来不及处理时，如何拒绝任务
        );
        testThenApply(executor);
        testThenAccept(executor);
        testExceptionally(executor);
        testWhenComplete2HaveValue(executor);
        testWhenComplete2Exception(executor);
    }

    /**
     * 对结果进行转换
     * @param executor
     */
    public static void testThenApply (ExecutorService executor) {
        String result = CompletableFuture.supplyAsync(() -> "hello", executor).
                thenApply(s -> s + " world1").join();
        System.out.println(result);
    }

    /**
     * 结果打印输出
     * @param executor
     */
    public static void testThenAccept (ExecutorService executor) {
        CompletableFuture.supplyAsync(() -> "hello", executor).
                thenAccept(s -> System.out.println(s + " world2"));
    }

    /**
     * 当运行时出现异常，可以通过此方式进行补偿
     * @param executor
     */
    public static void testExceptionally (ExecutorService executor) {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (1 == 1) {
                throw new RuntimeException("测试异常");
            }
            return "go";
        }, executor).exceptionally(e -> {
            System.out.println(e);
            return "hello world3";
        }).join();
        System.out.println(result);
    }

    /**
     * 记录每次运行完成的结果
     * 这里的完成有两种情况，一种是正常执行，有返回值；另外一种是抛出异常
     * 此处是抛出异常的情况
     *
     * @param executor
     */
    public static void testWhenComplete2HaveValue (ExecutorService executor) {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "go";
        }, executor).whenCompleteAsync((r, t) -> {
            System.out.println(r);
            System.out.println(t.getMessage());
        }, executor).exceptionally(e -> {
            System.out.println(e);
            return "hello world4";
        }).join();
        System.out.println(result);
    }

    /**
     * 记录每次运行完成的结果
     * 这里的完成有两种情况，一种是正常执行，有返回值；另外一种是抛出异常
     * 此处是抛出异常的情况
     *
     * @param executor
     */
    public static void testWhenComplete2Exception (ExecutorService executor) {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (1 == 1) {
                throw new RuntimeException("测试异常");
            }
            return "go";
        }, executor).whenCompleteAsync((r, t) -> {
            System.out.println(r);
            System.out.println(t.getMessage());
        }, executor).exceptionally(e -> {
            System.out.println(e);
            return "hello world5";
        }).join();
        System.out.println(result);
    }

}