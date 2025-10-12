package com.wyt.string;

import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个字符串：");
        String str = sc.next();

        // 调用方法替换字符
        String result = replaceChars(str);
        System.out.println("替换后的字符串：" + result);

        sc.close();
    }

    // 将字符串从索引3开始的4个字符替换为'*'
    static String replaceChars(String str) {
        // 检查字符串长度是否足够，避免索引越界
        if (str.length() < 3 + 4) {
            System.out.println("警告：字符串长度不足7个字符，无法替换指定范围的字符");
            return str; // 长度不足时返回原字符串
        }

        // 将字符串转换为字符数组（因为String不可变，需通过字符数组修改）
        char[] chars = str.toCharArray();

        // 替换从索引3开始的4个字符为'*'
        for (int i = 3; i < 3 + 4; i++) {
            chars[i] = '*';
        }

        // 将字符数组转回字符串并返回
        return new String(chars);
    }
}
