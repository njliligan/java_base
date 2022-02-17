package com.njganlili.callback;

import javax.security.auth.callback.Callback;

/**
 * @author njgan
 * @description
 * @date 2022/2/17 20:38
 */
public interface Answer extends Callback {

    public void tellAnswer(int answer);

}
