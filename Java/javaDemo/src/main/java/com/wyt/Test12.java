package com.wyt;

import java.util.Arrays;

public class Test12 {
    public static void main(String[] args) {
        // 1. 生成随机数组
        int[] randomArray = generateRandomArray(6, 100);
        System.out.println("生成的随机数组: " + Arrays.toString(randomArray));

        // 2. 计算统计值
        int sum = calculateSum(randomArray);
        int max = findMax(randomArray);
        int min = findMin(randomArray);
        int adjustedSum = sum - max - min;
        double average = calculateAdjustedAverage(randomArray, max, min);

        // 3. 输出结果
        printStatistics(sum, max, min, adjustedSum, average);
    }

    /**
     * 生成指定长度的随机数组
     * @param length 数组长度
     * @param bound 随机数上限(不包含)
     * @return 随机数组
     */
    private static int[] generateRandomArray(int length, int bound) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int)(Math.random() * bound);
        }
        return arr;
    }

    /**
     * 计算数组总和
     */
    private static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    /**
     * 查找数组最大值
     */
    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * 查找数组最小值
     */
    private static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    /**
     * 计算去掉最大最小值后的平均值
     */
    private static double calculateAdjustedAverage(int[] arr, int max, int min) {
        int sum = calculateSum(arr);
        return (sum - max - min) * 1.0 / (arr.length - 2);
    }

    /**
     * 打印统计结果
     */
    private static void printStatistics(int sum, int max, int min, int adjustedSum, double average) {
        System.out.println("数组总和: " + sum);
        System.out.println("去掉最大值和最小值后的和: " + adjustedSum);
        System.out.println("最大值: " + max);
        System.out.println("最小值: " + min);
        System.out.printf("去掉极值后的平均值: %.2f%n", average);
    }
}