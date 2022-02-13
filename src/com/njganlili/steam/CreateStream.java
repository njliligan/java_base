package com.njganlili.steam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author njgan
 * @description
 * @date 2022/2/13 9:55
 */
public class CreateStream {

    public static void main(String[] args) throws IOException {
        //单线程
        Stream<String> stringStream = new ArrayList<String>().stream();
        //多线程
        Stream<String> parallelStringStream1 = new ArrayList<String>().parallelStream();
        //.of初始化
        Stream<Integer> integerStreamOf = Stream.of(1,2,3,4,5);
        //.iterate初始化
        Stream<Integer> integerStreamIterate = Stream.iterate(0,(x)->x+1).limit(6);
        //Generate初始化
        Stream<Double> doubleStreamGenerate = Stream.generate(Math::random).limit(5);
        //使用BufferedReader.lines()，将行内容转化为流
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\njgan\\Documents\\hello.txt"));
        Stream<String> stringStreamFile = bufferedReader.lines();
        //使用Pattern.splitAsStream()，将字符串分割为流
        Pattern pattern = Pattern.compile(",");
        Stream<String> stringStreamPattern = pattern.splitAsStream("1,2,4,5,6,wr,sdf,s");
    }

}
