package org.wangyating;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            int next = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            for (int j = 0; j < next; j++){
                a.add(sc.nextInt());
            }
           double[] result= maxLongest(a);
            System.out.println("Case "+(i+1)+":");
            System.out.println(  (int)result[0]+" "+(int)result[1]+" "+(int)result[2]);
            if (i != n-1) System.out.println();
        }
    }
    public static double[] maxLongest(ArrayList<Integer> a){
        double maxSum=a.get(0);
        double tempSum=a.get(0);
        int start=1,end=1,tempStart=1;
        for (int i = 1; i < a.size(); i++){
            if(tempSum<0){
                tempSum=a.get( i);
                start=i+1;
            }else{
                tempSum+=a.get( i);
                }
            if(tempSum>maxSum){
                maxSum=tempSum;
                start=tempStart;
                end=i+1;
            }
        }
        return new double[]{maxSum,start,end};
    }
}
