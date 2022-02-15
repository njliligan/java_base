package com.njganlili.finalkey;

/**
 * @author njgan
 * @description
 * @date 2022/2/15 10:25
 */
public class Master {

    public static void main(String[] args){

        User user = new User();
        System.out.println(user.toString());
        user.setAge(111);
        user.setName("lllll");
        user.setQq("");
        System.out.println(user.toString());
    }

}
