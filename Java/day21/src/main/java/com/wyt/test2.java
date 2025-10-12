package com.wyt;

import java.util.HashMap;

public class test2 {
    public static void main(String args[]) {
        HashMap<Student, String> map = new HashMap<Student, String>();

        Student students0 = new Student("Alice", 18, "S001");
        Student students1 = new Student("Bob", 19, "S002");
        Student students2 = new Student("Charlie", 18, "S003");
        Student students3 = new Student("David", 20, "S004");
        Student students4 = new Student("Eve", 19, "S005");
        Student students5 = new Student("Frank", 21, "S006");
        Student students6 = new Student("Grace", 18, "S007");
        Student students7 = new Student("Hank", 20, "S008");
        Student students8 = new Student("Ivy", 19, "S009");
        map.put(students0, "北京");
        map.put(students1, "上海");
        map.put(students2, "广州");
        map.put(students3, "深圳");
        map.put(students4, "杭州");
        map.put(students5, "苏州");
        map.put(students6, "南京");
        map.put(students7, "西安");
        map.put(students8, "武汉");
        System.out.println(map);
        
    }
}
