package com.wyt.studentManage;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String sid;
    private String name;
    private String age;
    private String address;
    public Student()
    {
    }
    public Student(String sid, String name, String age, String address)
    {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public String getSid()
    {
        return sid;
    }
    public void setSid(String sid)
    {
        this.sid = sid;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getAge()
    {
        return age;
    }
    public void setAge(String age)
    {
        this.age = age;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public void show()
    {
        System.out.println("学号：" + sid + " 姓名：" + name + " 年龄：" + age + " 地址：" + address);
    }
    public static ArrayList<Student> addStudent(ArrayList<Student>  student, Student student1)
    {
        student.add(student1);
        return student;
    }
    public static  ArrayList<Student> deleteStudent(ArrayList<Student> student, String sid)
    {
        int  flag=1 ;
        for (int i = 0; i < student.size(); i++) {
            if (student.get(i).getSid().equals(sid)) {
                flag=0;
                student.remove(i);
                System.out.println("删除成功");
                break;
            }
        }
        if (flag==1)
        {
            System.out.println("未找到该学号");
        }
        return student;
    }
    public static ArrayList<Student> updateStudent(ArrayList<Student> student, String sid)
    {
        for (int i = 0; i < student.size(); i++) {
            if (student.get(i).getSid().equals(sid)) {
                Scanner sc=new Scanner(System.in);
                System.out.printf("请输入需要重置的学生的姓名：");
                String name = sc.next();
                System.out.printf("请输入需要重置的学生的年龄：");
                String age = sc.next();
                System.out.printf("请输入需要重置的学生的地址：");
                String address = sc.next();

                Student student1 = new Student(sid,name, age, address);

                student.set(i, student1);
                break;
            }
            System.out.printf("id不存在");
        }
        return student;
    }
    public static void showStudent(ArrayList<Student> student)
    {
        System.out.println("学号\t姓名\t年龄\t地址");
        for (int i = 0; i < student.size(); i++) {
            System.out.println(" " + student.get(i).getSid() + " " + student.get(i).getName() + " " +  student.get(i).getAge()   + " " + student.get(i).getAddress());
        }
    }
}

