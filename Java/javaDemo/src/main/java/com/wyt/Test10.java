package com.wyt;

import java.util.Scanner;

public class Test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个正整数（输入0退出）：");

        while (true) {
            int n = sc.nextInt();

            // 退出机制
            if (n == 0) {
                System.out.println("程序结束");
                break;
            }

            // 输入验证
            if (n <= 1) {
                System.out.print("不符合规范，请重新输入：");
                continue;
            }

            System.out.println(n + "以内的素数有：");

            // 检查2到n之间的所有数
            for (int i = 2; i <= n; i++) {
                boolean isPrime = true;

                // 只需检查到√i即可
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

                // 只在确定是素数后输出
                if (isPrime) {
                    System.out.print(i + " ");
                }
            }
            System.out.println("\n请输入下一个正整数（输入0退出）：");
        }
        sc.close();
    }
}