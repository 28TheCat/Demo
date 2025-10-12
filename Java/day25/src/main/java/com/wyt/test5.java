package com.wyt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class test5 {
    public static void main(String[] args) {
        // 将Map的value类型改为ArrayList<String>
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        //2.创建单列集合存储市
        ArrayList<String> city1 = new ArrayList<>();
        city1.add("南京市");
        city1.add("扬州市");
        city1.add("苏州市");
        city1.add("无锡市");
        city1.add("常州市");

        ArrayList<String> city2 = new ArrayList<>();
        city2.add("武汉市");
        city2.add("孝感市");
        city2.add("十堰市");
        city2.add("宜昌市");
        city2.add("鄂州市");

        ArrayList<String> city3 = new ArrayList<>();
        city3.add("石家庄市");
        city3.add("唐山市");
        city3.add("邢台市");
        city3.add("保定市");
        city3.add("张家口市");

        //3.把省份和多个市添加到map集合
        map.put("江苏省", city1);
        map.put("湖北省", city2);
        map.put("河北省", city3);
        for (String key : map.keySet()){
            System.out.println(key + ":" + map.get(key));
        }
    }
}
