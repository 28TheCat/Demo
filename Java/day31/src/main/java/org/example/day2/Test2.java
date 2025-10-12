package org.example.day2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,2,2, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        SentGift sg=new SentGift();
        Thread t=new Thread(sg,"王五");
        Thread t1=new Thread(sg,"王6");
        t.start();
        t1.start();
//        pool.submit(new Thread(sg,"张三"));
//        pool.submit(new Thread(sg,"李四"));
//        pool.shutdown();
    }
}
