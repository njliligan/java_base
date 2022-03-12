package com.njganlili.model.abstractfactory;

/**
 * @author njgan
 * @description
 * @date 2022/3/12 12:53
 */
public class Asexual implements Sex{
    @Override
    public void sex() {
        System.out.println("asexual");
    }
}
