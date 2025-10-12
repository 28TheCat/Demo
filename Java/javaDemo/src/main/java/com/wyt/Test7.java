package com.wyt;

import java.util.Arrays;

public class Test7 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        int[] newArr=copyOfRange(arr,2,5);
        System.out.println(Arrays.toString(newArr));
    }
    public static int[] copyOfRange(int[] arr,int start,int end){
        int[] newArr=new int[end-start];
        for (int i=start;i<end;i++){
            newArr[i-start]=arr[i];
        }
        return newArr;
    }
}
