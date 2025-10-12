package org.example;

import java.awt.*;
import java.lang.reflect.Method;
import java.sql.SQLOutput;

public class Demo6 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazz=Class.forName("org.example.Student");

        Method[] methods=clazz.getDeclaredMethods();
        for(Method method:methods) System.out.println( method);
        System.out.println("------------------------------------------");
        Method method2=clazz.getMethod("getAddress");
        System.out.println(method2);

//        Method method3=clazz.getMethod("getName",String.class);
//        System.out.println(method3);

        Method method4=clazz.getDeclaredMethod("getAge");
        System.out.println(method4);

    }
}
