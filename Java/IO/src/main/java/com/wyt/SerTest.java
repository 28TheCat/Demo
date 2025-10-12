package com.wyt;
//1. 将存有多个自定义对象的集合序列化操作，保存到list.txt文件中。
//        2. 反序列化list.txt ，并遍历集合，打印对象信息。
//
//案例分析
//
//1. 把若干学生对象 ，保存到集合中。
//        2. 把集合序列化。
//        3. 反序列化读取时，只需要读取一次，转换为集合类型。
//        4. 遍历集合，可以打印所有的学生信息

import java.io.*;
import java.util.ArrayList;

public class SerTest {
    public static void main(String[] args) {
        Student s1 = new Student("wyt", 18);
        Student s2 = new Student("Alice", 20);
        Student s3 = new Student("Bob", 21);
        Student s4 = new Student("cx", 19);
        Student s5 = new Student("Tom", 22);

        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);

        // 序列化
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("list.txt"));
            out.writeObject(list);  // ✅ 保存整个集合
            out.close();
            System.out.println("Serialized data is saved in list.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("=================================");

        // 反序列化
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("list.txt"));
            list = (ArrayList<Student>) in.readObject();  // ✅ 读回集合
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Student class not found");
            e.printStackTrace();
            return;
        }

        // 遍历集合
        System.out.println("Deserialized Students:");
        for (Student s : list) {
            System.out.println("Name: " + s.getName() + ", Age: " + s.getAge());
        }
    }
}