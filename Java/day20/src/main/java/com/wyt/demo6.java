package com.wyt;

import java.util.Calendar;

public class demo6 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        // 向后增加200天
        c.add(Calendar.DAY_OF_MONTH, 200);

        // 月份需要加1，因为Calendar的月份从0开始
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);

        System.out.println(year + "-" + month + "-" + day);
    }
}
