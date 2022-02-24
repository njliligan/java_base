package com.njganlili.juc.callback.tea.nomal;

/**
 * @author njgan
 * @description
 * @date 2022/2/18 11:31
 */
public class ColdDishThread extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("凉菜准备完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

