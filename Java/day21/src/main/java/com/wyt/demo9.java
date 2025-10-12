package com.wyt;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class demo9 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String,String>();
        map.put("A", "Apple");
        map.put("B", "Banana");
        map.put("C", "Cherry");
        map.put("D", "Date");
        map.put("E", "Elderberry");

        System.out.println( map);
        map.remove("E");
        System.out.println( map);
        Set< String> k=map.keySet();
        System.out.println(k);
        Collection< String> v=map.values();
        System.out.println(v);

    }
}
