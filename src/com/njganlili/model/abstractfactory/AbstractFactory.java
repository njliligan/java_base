package com.njganlili.model.abstractfactory;

import com.njganlili.model.factory.Behavior;

/**
 * @author njgan
 * @description
 * @date 2022/3/12 12:53
 */
public abstract class AbstractFactory {

    /**
     * 取得行为
     * @param behavior
     * @return
     */
    public abstract Behavior getBehavior(String behavior);

    /**
     * 取得性别
     * @param sex
     * @return
     */
    public abstract Sex getSex(String sex);

}
