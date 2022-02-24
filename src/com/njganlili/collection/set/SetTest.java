package com.njganlili.collection.set;

import java.util.*;

/**
 * @author njgan
 * @description
 * @date 2022/2/16 21:40
 */
public class SetTest {

    public static void main(String[] args ){

        //HashSet 是 Set 接口的主要实现类 ，HashSet 的底层是 HashMap，线程不安全的，可以存储null值；
        //LinkedHashSet 是 HashSet 的子类，底层是LinkHashMap，能够按照添加的顺序遍历；
        //TreeSet 底层使用红黑树，能够按照按照某种规则对元素进行排序，排序的方式有自然排序和定制排序。集合中的元素是有序的，集合中的元素是唯一的。

        HashSet set =new HashSet<>();
        set.add("as");
        LinkedHashSet<Object> objects = new LinkedHashSet<>();
        TreeSet treeSet = new TreeSet();
    }
}
