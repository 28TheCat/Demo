package com.wyt;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class prac4 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间：" + now);

        LocalDateTime birthday = LocalDateTime.of(2004, 5, 12, 0, 0, 0);
        System.out.println("生日：" + birthday);

        // 计算年龄（年）
        long years = ChronoUnit.YEARS.between(birthday, now);
        System.out.println("年龄：" + years + "岁");

        // 计算总天数差
        long days = ChronoUnit.DAYS.between(birthday, now);
        System.out.println("总天数差：" + days + "天");
    }
}
