package com.wyt.studentManage;

import java.util.ArrayList;
import java.util.Scanner;

import com.wyt.studentManage.Student;
import static com.wyt.studentManage.Student.deleteStudent;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> student = new ArrayList<Student>();
        Student student1 = new Student("1", "张三", "18", "上海");
        Student student2 = new Student("2", "李四", "19", "北京");
        Student student3 = new Student("3", "王五", "20", "广州");
        student.add(student1);
        student.add(student2);
        student.add(student3);
        User user = new User();
        
        Scanner sc = new Scanner(System.in);
        while ( true){
            System.out.println("欢迎来到学生管理系统");
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("3.忘记密码");
            System.out.printf("请选择你的操作：");
            int choice = sc.nextInt();
            switch (choice){
                case 1: if(user.login()) {
                    getStudents(sc, student);
                    if (student == null) return;
                }
                    break;
                    case 2:
                        user.register();
                        break;
                        case 3:user.forgetPassword();
                            break;
            }
        }
    }

    private static ArrayList<Student> getStudents(Scanner sc, ArrayList<Student> student) {
        int choice;
        System.out.println("1.添加学生信息");
        System.out.println("2.删除学生信息");
        System.out.println("3.修改学生信息");
        System.out.println("4.查询所有学生信息");
        System.out.println("5.退出");

        System.out.printf("请选择你的操作：");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.printf("请输入学生的学号：");
                String sid = sc.next();
                System.out.printf("请输入学生的姓名：");
                String name = sc.next();
                System.out.printf("请输入学生的年龄：");
                String age = sc.next();
                System.out.printf("请输入学生的地址：");
                String address = sc.next();
                Student studentNew = new Student(sid, name, age, address);
                student = Student.addStudent(student, studentNew);
                break;
                case 2:
                    System.out.println("请输入要删除学生的学号：");
                    String sidNew = sc.next();
                    student =deleteStudent(student, sidNew);
                    break;
                    case 3:
                        System.out.println("请输入要修改学生的学号：");
                        String sidUpdate = sc.next();
                        student =Student.updateStudent(student, sidUpdate);
                        break;
                        case 4:
                            Student.showStudent(student);
                            break;
                            case 5:
                                System.out.println("退出系统");
                                return null;
        }
        return student;
    }
}
