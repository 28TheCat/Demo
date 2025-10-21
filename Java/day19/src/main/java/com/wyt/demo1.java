// package com.wyt;

// public class demo1 {

//     public static void main(String[] args) {
//         String str="dsflafjsg";
//         System.out.println(str.matches("[a-z&&[^aeiou]]ad"));
//     }
// }
import java.util.Scanner;

public class Main {
    static int[][] food = new int[10000][12];
    static Integer cant=-10000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
    
            int maxTime = 0;

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int t = sc.nextInt();
                food[t][x]++;
                maxTime = Math.max(maxTime, t);
            }

            // dp 表示第 t 秒在位置 x 的最大馅饼数
            int[][] dp = new int[maxTime + 5][12];

            for (int j = 0; j <= 10; j++) dp[0][j] = cant;
            dp[0][5] = 0; 

            for (int t = 1; t <= maxTime; t++) {
                for (int x = 0; x <= 10; x++) {
                    //往左
                    int left  = (x > 0)  ? dp[t - 1][x - 1] : cant;
                    //呆着原地
                    int stay  = dp[t - 1][x];
                    //往右
                    int right = (x < 10) ? dp[t - 1][x + 1] : cant;

                    //找出最优解
                    int temp = Math.max(left, Math.max(stay, right));
                    dp[t][x] = food[t][x] + temp;
                }
            }

            // 找最大值
            int result = 0;
            for (int x = 0; x <= 10; x++) {
                result = Math.max(result, dp[maxTime][x]);
            }

            System.out.println(result);

        }

    
}
