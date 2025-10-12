package com.wyt;

import java.util.Arrays;
import java.util.Random;

public class Test14 {
    private static final int RED_BALL_COUNT = 6;
    private static final int RED_BALL_MAX = 33;
    private static final int BLUE_BALL_MAX = 16;
    private static final Random random = new Random();
    private static  int[] redBalls = generateRedBalls();
    private static int blueBall = generateBlueBall();

    public static void main(String[] args) {
        printResult(redBalls, blueBall);
        int[] balls = {13, 28 ,13 ,19, 21, 27 ,11};
        System.out.println(Arrays.toString(balls));
        printResult(balls);
    }
    static void printResult(int[] balls) {
        int win=0;
        int redBallCount = countMatchedRedBalls(balls, redBalls);
        if(balls[6]==blueBall){
            if(redBallCount==6){
                win=1;
            }
            else if(redBallCount==5){
                win=3;
            }
            else if(redBallCount==4){
                win=4;
            }
            else if(redBallCount==3){
                win=5;
            }
            else if(redBallCount==0||redBallCount==1||redBallCount==2){
                win=6;
            }
        }
        else{
            if(redBallCount==6){
                win=2;
            }
            else if(redBallCount==5){
                win=4;
            }
            else if(redBallCount==4){
                win=5;
            }
        }
        if(win==0) System.out.printf("很遗憾，您没有中奖");
        else System.out.printf("恭喜你，中%d等奖！",win);
    }
    public static int countMatchedRedBalls(int[] userRedBalls, int[] winningRedBalls) {
        // 首先对两个数组进行排序以便比较
        Arrays.sort(userRedBalls ,0, 6);
        Arrays.sort(winningRedBalls);

        int matchedCount = 0;
        int i = 0, j = 0;

        // 使用双指针算法计算匹配的红球数量
        while (i < userRedBalls.length-1 && j < winningRedBalls.length) {
            if (userRedBalls[i] == winningRedBalls[j]) {
                matchedCount++;
                i++;
                j++;
            } else if (userRedBalls[i] < winningRedBalls[j]) {
                i++;
            } else {
                j++;
            }
        }

        return matchedCount;
    }

    /**
     * 生成红球号码（1-33，不重复）
     */
    static int[] generateRedBalls() {
        int[] redBalls = new int[RED_BALL_COUNT];
        boolean[] used = new boolean[RED_BALL_MAX + 1];

        for (int i = 0; i < RED_BALL_COUNT; i++) {
            int num;
            do {
                num = random.nextInt(RED_BALL_MAX) + 1;
            } while (used[num]);

            redBalls[i] = num;
            used[num] = true;
        }

        Arrays.sort(redBalls); // 红球按从小到大排序
        return redBalls;
    }

    /**
     * 生成蓝球号码（1-16）
     */
    static int generateBlueBall() {
        return random.nextInt(BLUE_BALL_MAX) + 1;
    }

    /**
     * 打印结果
     */
    static void printResult(int[] redBalls, int blueBall) {
        System.out.print("双色球号码：");
        for (int redBall : redBalls) {
            System.out.printf("%02d ", redBall); // 两位数格式
        }
        System.out.printf("+ %02d%n", blueBall);
    }
}