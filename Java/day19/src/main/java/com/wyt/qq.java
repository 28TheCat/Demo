package com.wyt;

public class qq {
    public static void main(String[] args) {
        // 手机号示例
        String str1 = "13112345678";
        String str2 = "13712345667";
        String str3 = "13945679027";
        String str4 = "139456790271";  // 无效号码（12位）

        // 校验手机号的正则
        String regex = "^1[3-9]\\d{9}$";

        System.out.println(str1 + " 合法吗？ " + str1.matches(regex));
        System.out.println(str2 + " 合法吗？ " + str2.matches(regex));
        System.out.println(str3 + " 合法吗？ " + str3.matches(regex));
        System.out.println(str4 + " 合法吗？ " + str4.matches(regex));

        // 演示加数字组合再校验
        for (int i = 0; i < 10; i++) {
            String combinedStr = str1 + i;
            System.out.println(combinedStr + " 合法吗？ " + combinedStr.matches(regex));
        }

    }
}
