package com.wyt;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class demo6 {
    public static void main(String[] args) {
        Set<String> set=new TreeSet<>();
        set.add("111");
        set.add("222");
        set.add("333");
        set.add("111");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
        System.out.println("-----------------");
        for (String s : set){
            System.out.println(s);
        }
    }
}
