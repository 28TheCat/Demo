package com.wyt.string;

import java.util.Scanner;

public class StringDemo5 {
    public static void main(String[] args) {
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        System.out.println(reverse(str));
    }
    static String reverse(String str) {
        String str2 = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            str2 += str.charAt(i);
        }
        return str2;
    }
}
