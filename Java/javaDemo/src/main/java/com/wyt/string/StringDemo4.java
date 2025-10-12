package com.wyt.string;

import java.util.Scanner;
public class StringDemo4 {
    public static void main(String[] args) {
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        for (int i=0;i<str.length();i++){
            if(i==0) System.out.print("[");

            if(i==str.length()-1) System.out.println(str.charAt(i)+"]");
            else System.out.print(str.charAt(i)+",");
        }
    }
}
