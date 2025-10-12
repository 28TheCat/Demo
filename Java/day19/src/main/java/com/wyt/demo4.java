package com.wyt;

public class demo4 {
    public static void main(String[] args) {
        String str="020-2324242";
        System.out.println(str.matches("0[0-9]{2,3}-//d{4,9}"));
    }
}
