package com.wyt;

import java.util.Calendar;

public class demo4 {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH) + 1;
        int day = instance.get(Calendar.DAY_OF_MONTH);
        int hour=instance.get(Calendar.HOUR);
        int minute=instance.get(Calendar.MINUTE);
        int second=instance.get(Calendar.SECOND);
        int week=instance.get(Calendar.DAY_OF_WEEK);
        System.out.println(getWeek(week));
        System.out.println(year+"-"+month+"-"+day+"-"+hour+"-"+minute+"-"+second);
    }

    private static String getWeek(int week) {
        String[] weekArray = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        return weekArray[week-1];
    }
}
