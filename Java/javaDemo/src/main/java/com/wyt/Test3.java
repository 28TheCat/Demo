package com.wyt;

public class Test3 {
    public static void main(String[] args) {
        int[] arr=new int[10];
        int sum=0;
        for (int i=0;i<arr.length;i++){
            arr[ i]=(int)(Math.random()*100+1);
            System.out.println(arr[i]);
            sum+=arr[i];
        }
        System.out.println("总和");
        System.out.println(sum);
        System.out.println("平均数");
        double avg=sum/arr.length;
        System.out.println(avg);
        int cout=0;
        for(int i=0;i<arr.length;i++){
            if(arr[ i]<avg){
                cout++;
            }
        }
        System.out.println("小于平均数的个数");
        System.out.println(cout);
    }
}
