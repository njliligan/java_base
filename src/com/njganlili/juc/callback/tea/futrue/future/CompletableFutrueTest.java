package com.njganlili.juc.callback.tea.futrue.future;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.concurrent.*;

/**
 * @author njgan
 * @description
 * @date 2022/2/18 15:20
 */
//https://blog.csdn.net/finalheart/article/details/87615546
//带有supply是持有返回值的，run是void返回值的。在玩supply时发现一个问题如果使用supplyAsync任务时不使用任务的返回值。即不用get方法阻塞主线程会导致任务执行中断。
//Asynsc表示异步,而supplyAsync与runAsync不同在与前者异步返回一个结果,后者是void.第二个函数第二个参数表示是用我们自己创建的线程池,否则采用默认的ForkJoinPool.commonPool()作为它的线程池.其中Supplier是一个函数式接口,代表是一个生成者的意思,传入0个参数,返回一个结果.(
//同步获取结果
//public T    get()
//public T    get(long timeout, TimeUnit unit)
//public T    getNow(T valueIfAbsent)
//public T    join()
// getNow有点特殊，如果结果已经计算完则返回结果或者抛出异常，否则返回给定的valueIfAbsent值。join()与get()区别在于join()返回计算的结果或者抛出一个unchecked异常(CompletionException)，而get()返回一个具体的异常.
//public boolean complete(T  value)
//public boolean completeExceptionally(Throwable ex)
//上面方法表示当调用CompletableFuture.get()被阻塞的时候,那么这个方法就是结束阻塞,并且get()获取设置的value.

public class CompletableFutrueTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("executorService 是否为守护线程 :" + Thread.currentThread().isDaemon());
                return null;
            }
        });

        final CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("this is lambda supplyAsync");
            System.out.println("supplyAsync 是否为守护线程 " + Thread.currentThread().isDaemon());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this lambda is executed by forkJoinPool");
            return "result1";
        });
        final CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("this is task with executor");
            System.out.println("supplyAsync 使用executorService 时是否为守护线程 : " + Thread.currentThread().isDaemon());
            return "result2";
        }, executorService);

        final CompletableFuture<Void> future1 = CompletableFuture.runAsync(()->{

        });


        //验证守护线程
        final CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("this is lambda supplyAsync");
            System.out.println("supplyAsync 是否为守护线程 " + Thread.currentThread().isDaemon());
            try {
                TimeUnit.SECONDS.sleep(1);
                try(BufferedWriter writer = new BufferedWriter
                        (new OutputStreamWriter(new FileOutputStream(new File("/Users/zhangyong/Desktop/temp/out.txt"))))){
                    writer.write("this is completableFuture daemon test");
                }catch (Exception e){
                    System.out.println("exception find");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this lambda is executed by forkJoinPool");
            return "result1";
        });

        //allOf&anyOf
        //这两个方法的入参是一个completableFuture组、allOf就是所有任务都完成时返回。但是是个Void的返回值。
        //anyOf是当入参的completableFuture组中有一个任务执行完毕就返回。返回结果是第一个完成的任务的结果.

        //System.out.println(completableFuture.get());
        //System.out.println(future.get());
        executorService.shutdown();
    }

}
