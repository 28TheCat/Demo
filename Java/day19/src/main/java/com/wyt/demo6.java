package com.wyt;

public class demo6 {
    public static void main(String[] args) {
        String time="2025-03-23 12:01";
        String a="^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}$";
        System.out.println(time.matches(a));
    }
}
