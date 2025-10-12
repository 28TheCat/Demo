package com.wyt;

import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        int number = (int)(Math.random()*100+1);
        System.out.println("请输入数字：");
        Scanner sc = new Scanner(System.in);
        int num;
        while ((num = sc.nextInt())!=number) {
            if (num < number) {
                System.out.println("猜小了");
                continue;
            }
            else if (num > number){
                System.out.println("猜大了");
                continue;
            }

        }  System.out.println("猜对了");
    }
}
