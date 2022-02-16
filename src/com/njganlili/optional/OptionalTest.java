package com.njganlili.optional;

import com.njganlili.CommonUtil;
import com.njganlili.model.User;

import java.util.*;
import java.util.function.Supplier;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author njgan
 * @description
 * @date 2022/2/13 1:02
 */
public class OptionalTest {

    static int a = 1;

    public static void main(String[] args) {
        other();
    }

    static void ofNullableTest() {
        //可以为空
        User user = null;
        Optional<User> optionalUser = Optional.ofNullable(user);
        boolean empty = optionalUser.isEmpty();
        if (empty) {
            System.out.printf("为空");
        }
    }

    static void of() {
        User user = null;
        //这个of的参数不能为空，否则会报空指针异常。
        Optional<User> optionalUser = Optional.of(user);
    }

    static void empty() {
        User user = null;
        Optional<User> optionalUser = Optional.empty();
        boolean empty = optionalUser.isEmpty();
        if (empty) {
            System.out.printf("为空");
        }
    }

    static void other() {

        Map<String, List<User>> userGroup = new HashMap<>();

        Supplier<Optional<List<User>>> supplierListUser = new Supplier<>() {
            @Override
            public Optional<List<User>> get() {
                a++;
                return Optional.ofNullable(new ArrayList<>());
            }
        };

        List<User> users = CommonUtil.getUserList();
        Optional<List<User>> optionalUsers = Optional.ofNullable(users);
        //判断值是否存在
        System.out.println(optionalUsers.isPresent() ? System.out.printf("isPresent") : System.out.printf("isNotPresent"));
        System.out.println(optionalUsers.isPresent() ? System.out.printf("isPresent") : System.out.printf("isNotPresent"));

        optionalUsers.ifPresentOrElse(user -> {
            users.stream().collect(groupingBy(User::getUserSex));
        },()->{
            System.out.println("ifPresentoRElse");
        });
        //无论容器是否为空，只要调用该方法, 则对象other一定存在,orElse内的会始终被执行
        optionalUsers.orElse(new ArrayList<>());
        //只有当容器为空时,才调用supplier.get()方法产生对象
        optionalUsers.orElseGet(()->{
            return getListValue();
        });
        try {
            optionalUsers.orElseThrow(()->new Exception());
        } catch (Exception e) {
            e.printStackTrace();
        }
        optionalUsers.orElseThrow();
        //如果存在任何值，则此方法返回此Optional实例。如果此Optional实例中不存在任何值，则此方法返回一个Optional实例，其中包含从指定供应商生成的值
        optionalUsers.or(supplierListUser);
        System.out.println(a);
    }

    static List<User> getListValue(){
        //return "hello";
        return new ArrayList<>();
    }

}
