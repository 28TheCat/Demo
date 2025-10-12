package com.wyt;

import java.sql.SQLOutput;
import java.time.ZoneId;
import java.util.Set;

public class demo7 {
    public static void main(String[] args) {
        Set<String> zoneIds= ZoneId.getAvailableZoneIds() ;
        System.out.println(zoneIds.size());
        System.out.println(zoneIds);
        ZoneId zoneId1=ZoneId.of("Asia/Shanghai");
        System.out.println(zoneId1);
    }
}
