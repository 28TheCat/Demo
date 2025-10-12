package com.wyt;

import java.util.ArrayList;

public class demo3 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        System.out.println(list.size());
        list.add(1);
        System.out.println(list.size());
        ArrayList list1 = new ArrayList(list);
        System.out.println(list1);
    }


}
