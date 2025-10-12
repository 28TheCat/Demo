package com.wyt;

import java.time.Instant;

public class demo8 {
    public static void main(String[] args) {
        Instant now=Instant.now();
        System.out.println(now);
        Instant instant=Instant.ofEpochMilli(now.toEpochMilli());
        System.out.println(instant);
    }
}
