package com.wyt;

import java.util.Scanner;

public class Student {
    private String name;
    private int age;
    private int id;
    private static int nextId = 1;

    public Student(String name, int age, String address) {
        this.id = nextId++;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId++;
    }

    public Student() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    // 查找学生并返回其在数组中的索引
    public static int findIndex(Student[] students, int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static boolean deleteStudent(Student[] students, int id) {
        int index = findIndex(students, id);
        if (index != -1) {
            students[index] = null;
            return true;
        }
        return false;
    }

    public void show() {
        System.out.println("姓名：" + name + "，年龄：" + age + "，学号：" + id);
    }

    public static void main(String[] args) {
        Student[] students = new Student[3];
        Scanner sc = new Scanner(System.in);

        students[0] = new Student("张三", 18);
        students[1] = new Student("王五", 19);
        students[2] = new Student("赵六", 20);

        System.out.println("所有学生信息：");
        showStudents(students);

        System.out.print("\n请输入要查找的学生ID：");
        int findId = sc.nextInt();
        int findIndex = findIndex(students, findId);

        if (findIndex != -1 && students[findIndex] != null) {
            System.out.println("找到学生：");
            students[findIndex].show();
        } else {
            System.out.println("未找到ID为" + findId + "的学生");
        }

        System.out.print("\n请输入要删除的学生ID：");
        int deleteId = sc.nextInt();

        boolean isDeleted = deleteStudent(students, deleteId);
        if (isDeleted) {
            System.out.println("删除成功！");
            System.out.println("删除后的学生信息：");
            showStudents(students);
        } else {
            System.out.println("未找到ID为" + deleteId + "的学生，删除失败！");
        }
        System.out.print("\n查找id为1的学生：");
        int index = findIndex(students, 1);
        if (index != -1) {
            System.out.println("找到该学生，索引为：" + index);
            students[index].show();
            students[index].age++;
            students[index].show();
        } else {
            System.out.println("未找到ID为1的学生！");
        }


        sc.close();
    }

    // 显示所有非空学生信息
    public static void showStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) { // 只显示非空元素，避免空指针异常
                students[i].show();
            } else {
                System.out.println("位置 " + i + "：无学生信息");
            }
        }
    }
}
