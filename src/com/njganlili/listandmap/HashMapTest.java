package com.njganlili.listandmap;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author njgan
 * @description
 * @date 2022/2/16 17:25
 */
public class HashMapTest {

    public static void main(String[] args){
        //hash，list+链表
        //HashMap是由数组+链表形成，在JDK1.8之后链表长度大于8时转化为红黑树；而HashTable一直都是数组+链表,装载因子0.75
        HashMap<String,String> hashMap = new HashMap<>();
        //将按照条目放入 Map 的顺序迭代
        LinkedHashMap<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();
        //线程安全的
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        //基本被淘汰
        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
        //将根据它们的 compareTo() 方法(或外部提供的比较器)根据键的“自然排序”进行迭代。此外，它还实现 SortedMap 接口，该接口包含依赖于此排序顺序的方法
        TreeMap treeMap = new TreeMap();
        IdentityHashMap<Object, Object> objectObjectIdentityHashMap = new IdentityHashMap<>();
        objectObjectIdentityHashMap.put("sdf","sdf");
        objectObjectIdentityHashMap.put("sdf","sdfsdf");
        System.out.println(objectObjectIdentityHashMap.get("sdf"));
        if (new String("asdf") == new String("asdf")){
            System.out.println("string 对象相同");
        }
        if ("asdf" == "asdf"){
            System.out.println("string 对象相同");
        }
        hashMap.put(null,null);
        hashMap.put(null,"1");
        hashMap.put("1",null);
        hashMap.put("a","a");
        System.out.println(hashMap.get(null));
        System.out.println(hashMap.get("1"));

        Iterator iterator = hashMap.entrySet().iterator();
        if(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println("-------------------------------------------");
        for (Map.Entry<String,String> entry: hashMap.entrySet() ) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

}
