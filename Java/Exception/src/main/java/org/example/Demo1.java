package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
     Class clazz=   Class.forName("org.example.Student");
        System.out.println(clazz);
        Class clazz1=   Student.class;
        System.out.println(clazz1);
        if(clazz==clazz1) System.out.println("相同");
        Constructor con=clazz.getConstructor();
        Student student=(Student) con.newInstance();
        System.out.println(student);
    }
}
