package org.example.day2;

import java.util.concurrent.*;

// 一共有1000张电影票, 可以在两个窗口领取, 假设每次领取的时间为3000毫秒,
// 请用多线程模拟卖票过程并打印剩余电影票的数量

public class Test1 {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,
                2,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        SellTickes task = new SellTickes();

        pool.submit(task);
        pool.submit(task);

        pool.shutdown();
    }
}
