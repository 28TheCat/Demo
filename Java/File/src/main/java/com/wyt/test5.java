package com.wyt;

import java.io.File;

public class test5 {
    public static void main(String[] args) {
        File f = new File("src/daf");
        if (!f.exists()) {
            System.out.println("目录不存在！");
            return;
        }

        long totalSize = getLength(f);
        System.out.println("文件总大小：" + totalSize + " 字节");
    }

    public static long getLength(File f) {
        if (f == null || !f.exists()) return 0;

        if (f.isFile()) {
            System.out.println("文件：" + f.getName() + "，大小：" + f.length() + " 字节");
            return f.length();
        }

        long sum = 0;
        File[] files = f.listFiles();
        if (files != null) {
            for (File file : files) {
                sum += getLength(file); // 递归累加
            }
        }
        return sum;
    }
}
