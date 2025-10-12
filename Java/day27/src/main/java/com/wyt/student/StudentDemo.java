package com.wyt.student;

public class StudentDemo {
    public static void main(String[] args) {
        useStudentBuilder((name,age)->new Student(name,age));
        useStudentBuilder(Student::new);
    }
    public static void useStudentBuilder(StudentBuilder studentBuilder)
    {
        Student student=studentBuilder.build("张三",18);
        System.out.println(student.toString());
    }
}
