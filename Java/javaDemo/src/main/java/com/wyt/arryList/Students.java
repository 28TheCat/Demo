package com.wyt.arryList;

import com.wyt.Student;

import java.util.ArrayList;
import java.util.List;

public class Students {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        Student student1 = new Student("张三", 18, "北京");
        Student student2 = new Student("李四", 19, "上海");
        Student student3 = new Student("王五", 20, "广州");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        System.out.println("所有学生信息：");
        for (Student student : students) {
            System.out.printf(student.toString());
        }
    }
}
