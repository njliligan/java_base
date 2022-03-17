package com.njganlili.collection.list;

import com.njganlili.model.User;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author njgan
 * @description
 * @date 2022/3/16 22:06
 */
public class LinkedListTest {

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add(1);
        linkedList.add(new User());
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next.getClass().getTypeName());
            System.out.println(next);
        }
    }

}
