package org.example;

public class MyThreadDemo {
    public static void main(String[] args) {
        MyThread t = new MyThread("线程1");
        MyThread t1 = new MyThread("线程2");
        t1.start();
        t.start();
    }
}
