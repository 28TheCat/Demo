package com.wyt;

public class prac3 {
    public static void main(String[] args) {
        int a=4;
        System.out.println(toBinaryString(a));
    }
    public static String toBinaryString(int a) {
        if (a == 0)
            return "0";
        else {
            String str = "";
            while (a >= 1) {
                str = a  % 2+ str;
                a /= 2;
            }
            return str;
        }
    }
}
