package com.wyt;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {
    public static void main(String[] args) {
        Employee employee = new Employee("wyt", "beijing", 18);
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.txt"));
            out.writeObject(employee);
            out.close();
            System.out.println("Serialized data is saved in employee.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
