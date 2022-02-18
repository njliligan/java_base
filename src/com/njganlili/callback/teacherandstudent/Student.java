package com.njganlili.callback.teacherandstudent;

/**
 * @author njgan
 * @description
 * @date 2022/2/17 20:37
 */

import javax.security.auth.callback.Callback;

/** 2 * 学生接口，原文出处http://www.cnblogs.com/xrq730/p/6424471.html 3 */
public interface Student {
    public void resolveQuestion(Answer answer);
}
