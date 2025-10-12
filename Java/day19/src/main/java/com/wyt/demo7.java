package com.wyt;

public class demo7 {
    public static void main(String[] args) {
        String a="[0-9]{17}[0-9Xx]$";
        String id="43010219760604644X";
        System.out.println(id.matches(a));
    }
}
