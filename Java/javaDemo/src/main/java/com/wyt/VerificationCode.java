package com.wyt;

import java.util.Scanner;

public class VerificationCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入验证码位数：");
        int n = sc.nextInt();
        System.out.println(generateVerificationCode(n));
    }
    public static String generateVerificationCode(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int digit = (int)(Math.random()*62);
            if (digit < 10) {
                sb.append(digit);
            }
            else if (digit < 36) {
                sb.append((char)(digit + 'A' - 10));
            }
            else {
                sb.append((char)(digit + 'a' - 36));
            }
        }
        return sb.toString();
    }
}
