package org.example;

public class MyRunnableDemo {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        MyRunnable r1 = new MyRunnable();

        // 普通方法调用
        r.run();
        r1.run();

        // 启动新线程
        Thread t = new Thread(r, "ta");
        Thread t1 = new Thread(r1, "ew");
        t.start();
        t1.start();
    }
}