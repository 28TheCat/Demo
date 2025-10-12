package com.wyt;

import java.util.Iterator;
import java.util.LinkedList;

public class demo5 {
    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        Iterator< String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
