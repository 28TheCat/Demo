package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Field;

public class Demo8 {
    public static void main(String[] args) throws Exception {
        Student s = new Student("xiaoa", 18, "dsf");
        saveObject(s);
    }

    public static void saveObject(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        BufferedWriter bw= new BufferedWriter(new FileWriter("src/main/java/a.txt"));
        for (Field f : fields) {
            f.setAccessible(true); // 解除访问限制
            String name = f.getName();
            Object value = f.get(obj); // 获取字段值
            bw.write(name + "=" + value);
            bw.newLine();
            System.out.println(name + "=" + value);
        }
        bw.close();
    }
}
