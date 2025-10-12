package com.wyt;

import java.util.ArrayList;
import java.util.Scanner;

public class prac1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while (sum < 200) {
            System.out.print("请输入数字：");
            String str = sc.nextLine();

            try {
                int n = Integer.parseInt(str);

                if (n > 1 && n < 100) {
                    list.add(n);
                    sum += n;
                    System.out.println("当前总和：" + sum);

                    System.out.print("已输入的数字有：");
                    for (int num : list) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                } else {
                    System.out.println("输入错误，请输入1到99之间的数字。");
                }
            } catch (NumberFormatException e) {
                System.out.println("输入无效，请输入数字。");
            }
        }

        System.out.println("总和已达到200，程序结束！");
        sc.close();
    }
}
