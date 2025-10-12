package com.wyt;

import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        int t;
        for (int i=0;i<arr.length;i++){
            int temp=(int)(Math.random()*10);
            t=arr[temp];
            arr[temp]=arr[i];
            arr[i]=t;
        }
        System.out.println(Arrays.toString(arr));
    }
}
