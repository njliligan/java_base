package com.njganlili.juc.util;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

//Phaser就是用来解决这些问题的。Phaser将多个线程协作执行的任务划分为多个阶段，每个阶段都可以有任意个参与者，线程可以随时注册并参与到某个阶段。
//移相器，可以重复使用
//不是通过CAS
//分层栅栏
//比起CycliBarrier的主要是分层，每个线程都有阶段
public class PhaserTest {

    //MarriagePhaser 分阶段执行
    private final static Random RANDOM = new Random();

    public static void main(String[] args) {

        //初始化五个Phaser
        final Phaser phaser = new Phaser(5);

        for (int i = 0; i < 6; i++) {
            new Athletes(i,phaser).start();
        }

    }

    static class Athletes extends Thread {
        private final int no;
        private final Phaser phaser;


        Athletes(int no, Phaser phaser) {
            this.no = no;
            this.phaser = phaser;

        }

        @Override
        public void run() {
            try {
                System.out.println(no + " start running.");
                TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));
                System.out.println(no + " end running.");
                phaser.arriveAndAwaitAdvance();
                System.out.println("当前阶段数：" + phaser.getPhase());

                System.out.println(no + " start bicycle.");
                TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));
                System.out.println(no + " end bicycle.");
                phaser.arriveAndAwaitAdvance();
                System.out.println("当前阶段数："+ phaser.getPhase());

                System.out.println(no + " start long jump.");
                TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));
                System.out.println(no + " end long jump.");
                phaser.arriveAndAwaitAdvance();
                System.out.println("当前阶段数：" + phaser.getPhase());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
