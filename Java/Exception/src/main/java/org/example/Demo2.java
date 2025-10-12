package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo2 {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz=Class.forName("org.example.Student");
        Constructor constructor=clazz.getConstructor(String.class,int .class);
        constructor.setAccessible( true);
        Student student=(Student) constructor.newInstance("张三",18);
        System.out.println(student);
    }
    }

