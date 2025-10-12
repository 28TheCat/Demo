package com.wyt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo9 {
    public static void main(String[] args) {
        String str = "\t Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11，因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台。";

        String regex1 = "((?i)Java)(?=8|11|17)";   // 需求1
        String regex2 = "((?i)Java)(8|11|17)";    // 需求2
        String regex3 = "((?i)Java)(?:8|11|17)";  // 需求2（非捕获组）
        String regex4 = "((?i)Java)(?!8|11|17)";  // 需求3

        System.out.println("=== regex1 ===");
        find(str, regex1);

        System.out.println("=== regex2 ===");
        find(str, regex2);

        System.out.println("=== regex3 ===");
        find(str, regex3);

        System.out.println("=== regex4 ===");
        find(str, regex4);
        String str2 = "我要学学编编编编程程程程程程";

//需求:把重复的内容 替换为 单个的
//学学                学
//编编编编            编
//程程程程程程        程
//  (.)表示把重复内容的第一个字符看做一组
//  \\1表示第一字符再次出现
//  + 至少一次
//  $1 表示把正则表达式中第一组的内容，再拿出来用
        String result = str2.replaceAll("(.)\\1+", "$1");
        System.out.println(result);
    }

    public static void find(String text, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println("  " + m.group());
        }
    }
}
