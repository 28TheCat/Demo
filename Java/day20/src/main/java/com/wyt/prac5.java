package com.wyt;

import java.util.Calendar;

public class prac5 {
    public static void main(String[] args) {
        Calendar year = Calendar.getInstance();
        year.set(2004, 5, 27);
        System.out.println(isLeapYear( year));
        System.out.println(isLeapYear2(year));
    }
    public static boolean isLeapYear(Calendar  year) {
        if ((year.get(Calendar.YEAR) % 4 == 0 && year.get(Calendar.YEAR) % 100 != 0)
                || year.get(Calendar.YEAR) % 400 == 0)
        {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isLeapYear2(Calendar year) {
        int intyear = year.get(Calendar.YEAR);
        Calendar calendar = Calendar.getInstance();
        calendar.set(intyear, 1, 29); // 2月29日
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH) == 29;
    }

}
