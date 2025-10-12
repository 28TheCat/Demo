package com.wyt.ui;

public class Sds {
    public static void main(String[] args) {
        int[] a={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int b;
        for(int i=0;i<a.length;i++){
            b=(int)(Math.random()*a.length);
            int temp=a[i];
            a[i]=a[b];
            a[b]=temp;
        }
        int[][] c=new int[4][4];
        for(int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                c[i][j]=a[i*4+j];
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }

    }
}
