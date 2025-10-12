package com.wyt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class demo1 {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("hello");
        collection.add("world");
        System.out.println( collection);
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
        collection.remove("hello");
        System.out.println( collection);
    }
}
