package com.wyt;

import java.util.HashSet;

public class test1 {
  public static void main(String[] args) {
      Student[] students = new Student[10];

      students[0] = new Student("Alice", 18, "S001");
      students[1] = new Student("Bob", 19, "S002");
      students[2] = new Student("Charlie", 18, "S003");
      students[3] = new Student("David", 20, "S004");
      students[4] = new Student("Eve", 19, "S005");
      students[5] = new Student("Frank", 21, "S006");
      students[6] = new Student("Grace", 18, "S007");
      students[7] = new Student("Hank", 20, "S008");
      students[8] = new Student("Ivy", 19, "S009");
      students[9] = new Student("Ivy", 19, "S009");
      HashSet<Student> set = new HashSet<>();
      for(int i = 0; i < students.length; i++){
          boolean exists = false;
          for (Student s : set) {
              if (s.getName().equals(students[i].getName()) &&
                      s.getAge() == students[i].getAge() &&
                      s.getStudentId().equals(students[i].getStudentId())) {
                  exists = true;
                  break;
              }
          }
          if (!exists) {
              set.add(students[i]);
          }

      }
      System.out.println(set.toString());
    }
}