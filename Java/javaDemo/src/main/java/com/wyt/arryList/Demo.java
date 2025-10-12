package com.wyt.arryList;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<String>();
        list.add("hello");
        System.out.println(list.toString());
        list.add("world");
        System.out.printf(list.toString());
    }
}
