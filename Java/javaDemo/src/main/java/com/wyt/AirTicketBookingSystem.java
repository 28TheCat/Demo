package com.wyt;

import java.util.Scanner;

public class AirTicketBookingSystem {
    public static void main(String[] args) {
        System.out.println("欢迎来到机票管理系统");
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入机票原价");
        int a=scanner.nextInt();
        System.out.println("输入月份");
        int b=scanner.nextInt();
        System.out.println("头等舱1或经济舱2");
        int c=scanner.nextInt();

        System.out.println("机票价格");
        System.out.println(calculate(a,b,c));
    }
    static double[] bb(int b){
        double[] arr = new double[2];
        if(b<=0||b>12){
            System.out.println("月份输入错误");
            return null;
        }
        else if (b>=5&&b<=10){
            arr[0]=0.95;
            arr[1]=0.85;
        }
        else{
            arr[0]=0.7;
            arr[1]=0.65;
        }
        return arr;
    }

    static double calculate(int a,int b,int c){
        if(c==1){
            return a*bb(b)[0];
        }
        else return a*bb(b)[1];
    }
}
