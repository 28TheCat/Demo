package com.wyt;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.spi.LocaleServiceProvider;

public class demo11 {
    public static void main(String[] args) {
        LocalDateTime now=LocalDateTime.now();
        System.out.println(now);
        LocalDateTime birthday = LocalDateTime.of(2004, 5, 12, 0, 0, 0);
        System.out.println(birthday);
        Duration duration = Duration.between(birthday, now);
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
    }
}
