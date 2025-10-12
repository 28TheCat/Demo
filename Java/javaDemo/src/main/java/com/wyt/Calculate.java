package com.wyt;

import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入第一个数字");
        double num1 = sc.nextDouble();
        System.out.println("输入符号");
        String sign = sc.next();
        System.out.println("输入第二个数字");
        double num2 = sc.nextDouble();
        System.out.println(calculate(num1,num2,sign));
    }
    public static double calculate(double num1,double num2,String sign){
        double result = 0;
        switch (sign){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                System.out.println("输入的符号有误");
        }
        return result;
    }
}
