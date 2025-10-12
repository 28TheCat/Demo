package com.wyt;

import java.util.Calendar;

public class demo5 {
    public static void main(String[] args) {
        Calendar c1= Calendar.getInstance();
        c1.set(Calendar.YEAR,2004);
        c1.set(Calendar.MONTH,5);
        c1.set(Calendar.DAY_OF_MONTH,12);
        System.out.println(c1.get(Calendar.YEAR)+"年"+c1.get(Calendar.MONTH)+"月"+c1.get(Calendar.DAY_OF_MONTH)+"日"+c1.get(Calendar.WEEK_OF_MONTH));
    }
}
