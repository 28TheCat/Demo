package com.wyt;

public class Test2 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        int temp=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>=temp)temp=arr[i];
        }
        System.out.println(temp);
    }
}
