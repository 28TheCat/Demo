package com.wyt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class demo2 {
    public static void main(String[] args) throws  Exception{
        Date date=new Date();
        String str="2004-05-12";
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy年-MM月-dd日");
        date=sdf1.parse(str);
        System.out.println(date);
    }
}
