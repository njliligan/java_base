package com.njganlili.model.builder;

/**
 * @author njgan
 * @description
 * @date 2022/3/12 20:33
 */
public interface Animal {

    public String name();

    /**
     * 运动行为
     * @return
     */
    public String behavior();

    /**
     * 生活环境
     * @return
     */
    public Environment environment();

}
