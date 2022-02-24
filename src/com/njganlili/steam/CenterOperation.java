package com.njganlili.steam;

import com.njganlili.CommonUtil;
import com.njganlili.model.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author njgan
 * @description 中间操作
 * @date 2022/2/13 10:08
 */
public class CenterOperation {

    public static void main(String[] args){
        List<User> users = CommonUtil.getUserList();
        //1,筛选和切片
        List<User> userList =users.stream()
                //条件guolv
                .filter(user -> {return "M".equals(user.getUserSex());})
                //去重,使用hash和equals
                .distinct()
                //跳过n个元素
                .skip(1)
                //获取n个元素
                .limit(2)
                //收集
                .collect(Collectors.toList());
        for (User user : userList
             ) {
            System.out.println(user.toString());
        }
        //2，映射
        //map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        //flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        List<String> userMapList = users.stream().map(user ->
                user.getUserSex()
        ).collect(Collectors.toList());
        List<String> userSexStream = users.stream().flatMap(user -> {
            return Stream.of(user.getUserSex());
        }).collect(Collectors.toList());
        //3,排序
        //sorted()：自然排序，流中元素需实现Comparable接口
        //sorted(Comparator com)：定制排序，自定义Comparator排序器
        List<User> userSort = users.stream().sorted().collect(Collectors.toList());
        List<User> userSortBySelf = users.stream().sorted(((o1, o2) -> {
            if (o1.getUserAge() .equals( o2.getUserAge())){
                return o1.getUserName().compareTo(o2.getUserName());
            }else {
                return o1.getUserAge().compareTo(o2.getUserAge());
            }
        })).collect(Collectors.toList());
        //4,消费
        //peek：如同于map，能得到流中的每一个元素。但map接收的是一个Function表达式，有返回值；而peek接收的是Consumer表达式，没有返回值。
        List<User> userPeeks = users.stream().peek(user -> {user.setUserAge(100);}).collect(Collectors.toList());
    }

}
