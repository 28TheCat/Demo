package com.wyt;

import java.util.Scanner;

import static java.lang.Math.random;

public class arr {
    public static void main(String[] args) {
//        int[][] arr = new int[4][4];
//        int count = 1;
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                if (i == 3 && j == 3) {
//                    break;
//                } else {
//                    arr[i][j] = count++;
//                }
//            }
//        }
//
//        System.out.println("原始数组：");
//        printArray(arr);
//
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                int m = (int) (random() * arr.length);
//                int p = (int) (random() * arr.length);
//                int temp=0;
//                 temp=arr[m][p];
//                 arr[m][p]=arr[i][j];
//                 arr[i][j]=temp;
//            }
//        }
//
//        System.out.println("随机新数组：");
//        printArray(arr);
        arr2();
    }

    public static void printArray(int[][] arr) {
        for (int[] row : arr) {
            for (int num : row) {
                System.out.printf("%2d ", num);
            }
            System.out.println();
        }
    }
    public static void arr2() {
        String[][] classroom={
                {"张三","王五","赵六"},
                {"张四","王9","赵1","周五"},
                {"张五","王6"}
        };
        String []classroom1=null;
        int count=0;
        for (int i = 0; i < classroom.length; i++){
            for (int j = 0; j < classroom[i].length; j++){
                int m=(int)Math.random()*classroom.length;
                int n=(int)Math.random()*classroom[m].length;
                if(classroom[i][j]!=null) {
                    String temp=null;
                    temp=classroom[i][ j];
                    classroom[i][j]=classroom[m][ n];
                    classroom[m][n]=temp;
                }
            }
        }
       System.out.println("随机后的教室座位图：");
        for (int i = 0; i < classroom.length; i++){
            for (int j = 0; j < classroom[i].length; j++){
                System.out.print(classroom[i][j]+" ");
            }
            System.out.println();
        }

        }
    }
