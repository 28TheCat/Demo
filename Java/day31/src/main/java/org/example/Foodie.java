package org.example;

public class Foodie implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.foodCount == 0) {
                    try {
                        Desk.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() +
                            " 正在吃第 " + Desk.foodCount + " 个食物");
                    Desk.foodCount--;
                    Desk.lock.notifyAll();
                }
            }
        }
    }
}
