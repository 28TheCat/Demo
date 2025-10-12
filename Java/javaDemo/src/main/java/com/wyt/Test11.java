package com.wyt;

import java.util.Scanner;

public class Test11 {

    /**
     * 从源数组中复制指定范围的元素到新数组
     * @param source 源数组
     * @param start 起始索引(包含)
     * @param end 结束索引(不包含)
     * @return 新数组
     * @throws IllegalArgumentException 如果索引不合法
     */
    public static char[] copyArrayRange(char[] source, int start, int end) {
        // 参数校验
        if (start < 0 || end > source.length || start >= end) {
            throw new IllegalArgumentException("无效的索引范围");
        }

        char[] result = new char[end - start];
        System.arraycopy(source, start, result, 0, end - start);
        return result;
    }

    public static void main(String[] args) {
        char[] char1 = {'a', 'b', 'c', 'd', 'e'};
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("请输入起始索引(0-" + (char1.length-1) + "): ");
            int n1 = sc.nextInt();

            System.out.print("请输入结束索引(" + (n1+1) + "-" + char1.length + "): ");
            int n2 = sc.nextInt();

            // 调用复制函数
            char[] char2 = copyArrayRange(char1, n1, n2);

            // 输出结果
            System.out.println("复制后的数组内容: ");
            for (char c : char2) {
                System.out.print(c + " ");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("错误: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}