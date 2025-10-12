package org.example;

import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Demo4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class clazz=Class.forName("org.example.Student");
        Field[] fields=clazz.getFields();
        for (Field field:fields){
            System.out.println(field);
        }
        System.out.println("=======================");
        Field[] field2=clazz.getDeclaredFields();
        for (Field field:field2){
            System.out.println(Arrays.toString(field2));
        }
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        System.out.println("=======================");
        Field field3=clazz.getField("name");
        System.out.println(field3);
        System.out.println("=======================");
        Field field5=clazz.getDeclaredField("age");
        System.out.println(field5);
    }
}
