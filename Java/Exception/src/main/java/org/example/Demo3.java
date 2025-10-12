package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Properties properties=new Properties();
        FileInputStream fis=new FileInputStream("prop.properties");
        properties.load(fis);
        System.out.println(properties);

        String classname=(String) properties.get("classname");
        String methodname=(String) properties.get("method");
        System.out.println(classname);
        System.out.println(methodname);

        Class clazz=Class.forName(classname);
        Object obj= clazz.getDeclaredConstructor();
        System.out.println( obj);

        Method method=clazz.getDeclaredMethod(methodname);
        method.setAccessible( true);
//        method.invoke(obj);
    }
}
