package com.wyt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo8 {
    public static void main(String[] args) {
        String str = "来黑马程序员学习Java，手机号:18512516758，18512508907或者联系邮箱:boniu@itcast.cn，座机电话:01036517895，010-98951256邮箱:bozai@itcast.cn，热线电话:400-618-9090 ，400-618-4000，4006184000，4006189090手机号的正则表达式:1[3-9]\\d{9}";

        // 手机号
        String phoneRegex = "1[3-9]\\d{9}";
        // 邮箱
        String emailRegex = "\\w+@[\\w&&[^_]]{2,6}(\\.[a-zA-Z]{2,3}){1,2}";
        // 座机电话（010xxxx 或 010-xxxx）
        String telRegex = "0\\d{2,3}-?[1-9]\\d{4,9}";
        // 400 电话
        String hotlineRegex = "400-?\\d{3}-?\\d{4}";

        // 查手机号
        System.out.println("📱 手机号：");
        findMatch(str, phoneRegex);

        // 查邮箱
        System.out.println("📧 邮箱：");
        findMatch(str, emailRegex);

        // 查座机
        System.out.println("☎️ 座机电话：");
        findMatch(str, telRegex);

        // 查400热线
        System.out.println("📞 热线电话：");
        findMatch(str, hotlineRegex);
    }

    // 工具方法：打印所有匹配结果
    private static void findMatch(String text, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println("  " + m.group());
        }
    }
}
