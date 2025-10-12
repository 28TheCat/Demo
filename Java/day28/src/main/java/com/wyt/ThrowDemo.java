package com.wyt;

public class ThrowDemo {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int index=6;
        int element=getelement(arr,index);
    }
    public static int getelement(int[] arr,int index){
        if(index<0||index>=arr.length){
            throw new ArrayIndexOutOfBoundsException("数组越界");
        }
        return arr[index];
    }
}
