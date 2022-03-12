package com.njganlili.model.abstractfactory;

/**
 * @author njgan
 * @description
 * @date 2022/3/12 12:52
 */
public class Man implements Sex{
    @Override
    public void sex() {
        System.out.println("man");
    }
}
