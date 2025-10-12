package org.example.day2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test3 {
    public static void main(String[] args) {
        // 5 个用户
        Thread t1 = new Thread(new RedBag("用户A"));
        Thread t2 = new Thread(new RedBag("用户B"));
        Thread t3 = new Thread(new RedBag("用户C"));
        Thread t4 = new Thread(new RedBag("用户D"));
        Thread t5 = new Thread(new RedBag("用户E"));

        // 同时启动
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

