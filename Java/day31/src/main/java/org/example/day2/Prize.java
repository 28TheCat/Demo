package org.example.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Prize implements Runnable {

    private static ArrayList<Integer> moneys = new ArrayList<>();
    private static final Object lock = new Object();
    private ArrayList<Integer> moneyGet = new ArrayList<>();

    static {
        moneys.addAll(Arrays.asList(10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700));
    }

    private String userName;

    public Prize(String userName) {
        this.userName = userName;
    }

    public List<Integer> getAllMoney() {
        return Collections.unmodifiableList(moneyGet);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (!moneys.isEmpty()) {
                    Collections.shuffle(moneys);
                    int money = moneys.remove(0);
                    moneyGet.add(money);
                    System.out.println(userName + " 抢到了 " + money + " 元大奖");
                } else {
                    System.out.println(userName + " 没抢到奖品");
                    return;
                }
            }

            try {
                Thread.sleep(100); // 模拟抢奖品延迟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
