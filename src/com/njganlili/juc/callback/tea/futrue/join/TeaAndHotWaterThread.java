package com.njganlili.juc.callback.tea.futrue.join;

/**
 * @author njgan
 * @description
 * @date 2022/2/18 11:36
 */
public class TeaAndHotWaterThread {

    private static volatile boolean hot_water = false;

    public static class HotWaterThread extends Thread{
        @Override
        public void run() {
            try{
                Thread.sleep(3000L);
                hot_water = true;
                System.out.println("水已经烧开");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static class TeaThread extends Thread{
        @Override
        public void run() {
            try{
                if(hot_water){
                    Thread.sleep(1000L);
                    System.out.println("茶泡好了");
                }else{
                    System.out.println("没有热水");
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
