package com.wyt;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Locale;

public class demo9 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        Locale locale = Locale.getDefault();
        System.out.println(locale);

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.getMonthValue());

        // Correct way to compare dates
        LocalDate compareDate = LocalDate.of(2021, 10, 10);
        System.out.println(localDate.isBefore(compareDate));
        LocalDate compareDate2 = LocalDate.of(2021, 10, 11);
        System.out.println(localDate.isAfter(compareDate2));
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
