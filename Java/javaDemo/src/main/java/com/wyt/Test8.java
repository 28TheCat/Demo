package com.wyt;

public class Test8 {
    public static void main(String[] args) {
        int n=90;
        System.out.println(n);
        change(n);
        System.out.println(n);

        //改变堆引用
        System.out.println();
        int[] arr1=new int[]{0,2,3};
        System.out.println(arr1[0]);
        System.out.println("arr1[0]改变之后是");
        changeArr(arr1);
        System.out.println(arr1[0]);

    }
    static void change(int n){
        n=100;
    }
    static void changeArr(int[] arr){
        arr[0]=1;
    }
}
