package org.example.day2;

import java.util.Random;

public class RedBag implements Runnable {
    private static int count = 3;         // 红包个数
    private static double money = 100;    // 红包总额
    private static final Object lock = new Object(); // 锁对象

    private String userName;

    public RedBag(String userName) {
        this.userName = userName;
    }

    @Override
    public void run() {
        synchronized (lock) {
            if (count <= 0) {
                System.out.println(userName + " 没抢到");
                return;
            }

            double grabMoney;
            if (count == 1) {
                // 最后一个红包，直接拿剩余的钱
                grabMoney = money;
            } else {
                Random random = new Random();
                grabMoney = Math.round(random.nextDouble() * (money - count + 1) * 100) / 100.0;
            }

            money -= grabMoney;
            money = Math.round(money * 100) / 100.0; // 保留两位小数
            count--;

            System.out.println(userName + " 抢到了 " + grabMoney + " 元");
        }
    }
}
