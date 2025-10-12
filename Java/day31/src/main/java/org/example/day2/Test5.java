package org.example.day2;

import java.util.List;

public class Test5 {
    public static void main(String[] args) throws InterruptedException {
        Prize p1 = new Prize("抽奖箱1");
        Prize p2 = new Prize("抽奖箱2");

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        printPrizeInfo("抽奖箱1", p1);
        printPrizeInfo("抽奖箱2", p2);
    }

    private static void printPrizeInfo(String name, Prize prize) {
        int total = 0;
        int max = 0;
        List<Integer> allMoney = prize.getAllMoney();
        for (Integer money : allMoney) {
            total += money;
            if (money > max) max = money;
        }
        System.out.println(name + " 抢到总额：" + total + " 元，最大奖品：" + max + " 元");
    }
}
