package com.njganlili;

import com.njganlili.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author njgan
 * @description
 * @date 2022/2/13 10:09
 */
public class CommonUtil {

    public static List<User> getUserList(){
        List<User> users = new ArrayList<>();
        users.add(new User().setAge(18).setName("lili").setSex("M"));
        users.add(new User().setAge(19).setName("miky").setSex("M"));
        users.add(new User().setAge(17).setName("miks").setSex("M"));
        users.add(new User().setAge(24).setName("jack").setSex("W"));
        users.add(new User().setAge(30).setName("lose").setSex("W"));
        return users;
    }


}
