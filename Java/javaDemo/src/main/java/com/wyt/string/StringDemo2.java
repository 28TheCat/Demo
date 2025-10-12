package com.wyt.string;

import java.util.Scanner;

public class StringDemo2 {
    public static void main(String[] args) {
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        int aa=0;
        int a1=0;
        int aA=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='a'&&str.charAt(i)<='z'){
                aa++;
            }
            else if(str.charAt(i)>='A'&&str.charAt(i)<='Z'){
                aA++;
            }
            else if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                a1++;
            }

        }
        System.out.println(str);
        System.out.println("小写字母的个数："+aa);
        System.out.println("大写字母的个数："+aA);
        System.out.println("数字的个数："+a1);
    }
}
