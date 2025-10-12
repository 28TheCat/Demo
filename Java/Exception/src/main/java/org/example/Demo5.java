package org.example;

import java.lang.reflect.Field;

public class Demo5 {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        Student s=new Student("张三",18,"dsfa");
        Student ss=new Student("张三d",183,"dsfa");

        Class clazz=Class.forName("org.example.Student");
        Field field=clazz.getDeclaredField("name");
        field.setAccessible(true);

        field.set(s,"张三改后");
        String result=(String)field.get(s);

        System.out.println(s);
        System.out.println(ss);
    }
}
