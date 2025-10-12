package org.example;

public class Demo1 {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        MyThread t1=new MyThread();
        t.run();
        t1.start();
    }
}
