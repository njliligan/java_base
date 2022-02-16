package com.njganlili;

import com.njganlili.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author njgan
 * @description
 * @date 2022/2/13 10:09
 */
public class CommonUtil {
    public static List<User> getUserList(){
        List<User> users = new ArrayList<>();
        users.add(new User()
                .setUserAge(18)
                .setUserName("lili")
                .setUserSex("M")
                .setId("1")
                .setRevision("")
                .setUserIdCard("000000000")
                .setCreatedBy("miky")
                .setCreatedTime(new Date())
                .setUpdatedBy("miky")
                .setUpdatedTime(new Date()));
        users.add(new User()
                .setUserAge(19)
                .setUserName("lilis")
                .setUserSex("M")
                .setId("2")
                .setRevision("")
                .setUserIdCard("000000001")
                .setCreatedBy("miky")
                .setCreatedTime(new Date())
                .setUpdatedBy("miky")
                .setUpdatedTime(new Date()));
        users.add(new User()
                .setUserAge(18)
                .setUserName("lilisdf")
                .setUserSex("W")
                .setId("3")
                .setRevision("")
                .setUserIdCard("000000002")
                .setCreatedBy("miky")
                .setCreatedTime(new Date())
                .setUpdatedBy("miky")
                .setUpdatedTime(new Date()));
        users.add(new User()
                .setUserAge(20)
                .setUserName("lili")
                .setUserSex("W")
                .setId("4")
                .setRevision("")
                .setUserIdCard("000000003")
                .setCreatedBy("miky")
                .setCreatedTime(new Date())
                .setUpdatedBy("miky")
                .setUpdatedTime(new Date()));
        users.add(new User()
                .setUserAge(20)
                .setUserName("lili")
                .setUserSex("M")
                .setId("5")
                .setRevision("")
                .setUserIdCard("000000004")
                .setCreatedBy("miky")
                .setCreatedTime(new Date())
                .setUpdatedBy("miky")
                .setUpdatedTime(new Date()));
        return users;
    }

}
