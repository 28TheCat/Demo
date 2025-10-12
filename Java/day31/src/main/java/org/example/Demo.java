package org.example;

public class Demo {
    public static void main(String[] args) {
//        MyRunnable r = new MyRunnable();
//        MyRunnable r1 = new MyRunnable();
//        r.run();
//        r1.run();
        System.out.println("hello world");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("hello world");
    }
}
