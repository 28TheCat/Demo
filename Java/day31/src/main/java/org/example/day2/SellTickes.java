package org.example.day2;

public class SellTickes implements Runnable{

    private int tickets = 100;  // 总票数
    private final Object lock = new Object(); // 锁对象



    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (tickets <= 0) {
                    break; // 卖完票就退出
                }
                try {
                    Thread.sleep(3000); // 模拟出票时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 卖出第 " + tickets-- + " 张票");
            }
        }
    }
}
