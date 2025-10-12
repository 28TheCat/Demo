package com.wyt;

public class checkQQ {
    public static void main(String [] args){
        String QQ="1234567890";
        System.out.print(QQ.matches("[1-9]\\d{5,19}"));
    }
}
