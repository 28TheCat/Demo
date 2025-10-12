package com.wyt;

import java.util.Random;

public class Test15 {
    // 奖项配置: {奖金金额, 初始数量, 剩余数量}
    private static int[][] prizes = {
            {1000, 2, 2},   // 1000元奖
            {100, 588, 588}, // 100元奖
            {50, 888, 888},  // 50元奖
            {10, 1000, 1000}, // 10元奖
            {1, 10000, 10000} // 1元奖
    };

    // 各奖项的中奖权重(可调整)
    private static final int[] weights = {1, 10, 20, 30, 39};

    public static void main(String[] args) {
        // 模拟抽奖10000次
        for (int i = 1; i <= 10000; i++) {
            if (!hasPrizesLeft()) {
                System.out.println("所有奖品已抽完！");
                break;
            }

            int prizeIndex = drawPrize();
            if (prizeIndex != -1) {
                System.out.printf("第%d次抽奖: 获得%d元奖%n", i, prizes[prizeIndex][0]);
            }
        }

        // 打印抽奖统计结果
        printStatistics();
    }

    // 执行一次抽奖，返回获奖奖项索引
    static int drawPrize() {
        Random random = new Random();

        // 计算当前有效总权重
        int totalWeight = 0;
        for (int i = 0; i < prizes.length; i++) {
            if (prizes[i][2] > 0) {
                totalWeight += weights[i];
            }
        }

        // 随机选择奖项
        int randomNum = random.nextInt(totalWeight);
        int cumulativeWeight = 0;

        for (int i = 0; i < prizes.length; i++) {
            if (prizes[i][2] > 0) {
                cumulativeWeight += weights[i];
                if (randomNum < cumulativeWeight) {
                    prizes[i][2]--; // 减少库存
                    return i;
                }
            }
        }

        return -1; // 未中奖(理论上不会执行到这里)
    }

    // 检查是否还有奖品剩余
    static boolean hasPrizesLeft() {
        for (int[] prize : prizes) {
            if (prize[2] > 0) {
                return true;
            }
        }
        return false;
    }

    // 打印统计结果
    static void printStatistics() {
        System.out.println("\n抽奖结果统计:");
        System.out.println("奖项\t初始数量\t剩余数量\t中奖数量");
        for (int[] prize : prizes) {
            System.out.printf("%d元\t%d\t%d\t%d%n",
                    prize[0], prize[1], prize[2], prize[1] - prize[2]);
        }

        int totalGiven = 0;
        for (int[] prize : prizes) {
            totalGiven += (prize[1] - prize[2]) * prize[0];
        }
        System.out.println("\n总发放奖金: " + totalGiven + "元");
    }
}