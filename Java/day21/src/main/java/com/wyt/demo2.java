package com.wyt;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class demo2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        list.remove(0);
        list.add(0, 4);
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        List<String> strList = new ArrayList<>();
        strList.add("hello");
        strList.add("world");
        System.out.println(strList);

        for (String str : strList) {
            System.out.print(str + " ");
        }
        System.out.println();

        strList.forEach(str -> System.out.print(str + " "));
        System.out.println();

        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println("Iterator: " + listIterator.next());
        }
    }
}
