package com.njganlili.annotations;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;

public class Test {

    public static void main(String[] args){
        Class user = new User().getClass();
        Field[] fields = user.getDeclaredFields();
        for (Field f: fields
             ) {
            CellStyle cellStyle =  f.getAnnotation(CellStyle.class);
            System.out.println(cellStyle.age());
            System.out.println(cellStyle.name());
            System.out.println("-----------------------------------------");
        }
    }

}
