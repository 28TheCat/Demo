package com.wyt;

public class demo1 {

    public static void main(String[] args) {
        String str="dsflafjsg";
        System.out.println(str.matches("[a-z&&[^aeiou]]ad"));
    }
}
