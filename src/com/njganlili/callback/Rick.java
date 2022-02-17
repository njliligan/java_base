package com.njganlili.callback;

/**
 * @author njgan
 * @description
 * @date 2022/2/17 20:42
 */

import javax.security.auth.callback.Callback;

/** 2 * 一个名叫Ricky的同学解决老师提出的问题，原文出处http://www.cnblogs.com/xrq730/p/6424471.html 3 */
public class Rick implements Student {

    @Override
    public void resolveQuestion(Answer answer) {
        // 模拟解决问题
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

        // 回调，告诉老师作业写了多久
        answer.tellAnswer(3);
    }
}
