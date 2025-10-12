package com.wyt;

public class prac2 {
    public static void main(String[] args) {
        String str = "1241423";
        String str1 = "d0123";
        change(str);
        change(str1);
    }
    public static void change(String  str) {
        if (!str.matches("[0-9]+")) {
            System.out.println("输入错误");
        } else {
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += (str.charAt(i) - '0') * Math.pow(10, str.length() - i - 1);
                System.out.println(sum);
            }
        }
    }
}
