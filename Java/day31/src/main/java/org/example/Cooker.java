package org.example;

public class Cooker extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.foodCount >= 10) {
                    try {
                        Desk.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    Desk.foodCount++;
                    System.out.println(Thread.currentThread().getName() +
                            " 正在做第 " + Desk.foodCount + " 个食物");
                    Desk.lock.notifyAll(); // 唤醒吃货
                }
            }
        }
    }
}
