package com.wyt;

import java.text.SimpleDateFormat;
import java.util.Date;

public class demo3 {
    public static void main(String[] args) throws Exception {
        String str1 = "2023年11月11日 0:0:0";
        String str2 = "2023年11月11日 0:10:0";
        String str3 = "2023年11月11日 0:01:0";
        String str4 = "2023年11月11日 0:11:0";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 H:m:s");

        Date date1 = sdf.parse(str1);
        Date date2 = sdf.parse(str2);
        Date date3 = sdf.parse(str3);
        Date date4 = sdf.parse(str4);

        if (date1.after(date3) || date2.before(date3)) {
            System.out.println("购买失败");
        } else {
            System.out.println("购买成功");
        }

        if (date1.after(date4) || date2.before(date4)) {
            System.out.println("购买失败");
        } else {
            System.out.println("购买成功");
        }
    }
}
