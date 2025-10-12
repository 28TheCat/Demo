package com.wyt;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int n = sc.nextInt();
        boolean flag=true;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                flag=false;
                System.out.println("不是素数");
                break;
            }
        }
        if(flag==true)
        System.out.println("是素数");
    }
}