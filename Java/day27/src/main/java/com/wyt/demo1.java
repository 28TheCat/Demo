package com.wyt;

import java.util.Iterator;
import java.util.List;

public class demo1 {
    public static void main(String[] args) {
        List<String> list=List.of("1","2","3");
        System.out.println( list.get(0));
        System.out.println( list.get(1));
        System.out.println( list.get(2));
        System.out.println("===================");
        for(String s:list){
            System.out.println(s);
        }
        Iterator<String> iterator=list.iterator();
        while (iterator.hasNext()){
            String s= iterator.next();
            System.out.println(s);
        }
        System.out.println("===================");
    }
}
