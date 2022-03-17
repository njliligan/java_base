package com.njganlili.collection.list;

import java.util.ArrayList;

/**
 * @author njgan
 * @description
 * @date 2022/3/16 22:05
 */
public class ArrayListTest {

    public static void main(String[] args){
        //当不声明ArrayList数组里面有什么类型的时候，什么东西都能存
        ArrayList arrayList = new ArrayList<String>();
        arrayList.add("s");
        arrayList.add(1);
        System.out.println(arrayList.get(1).getClass().getTypeName());
        for (int i =0;i< arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
    }

}
