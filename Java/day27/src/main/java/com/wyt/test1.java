package com.wyt;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class test1 {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        ArrayList<Integer> list2=new ArrayList<>();
        list2=(ArrayList<Integer>) list.stream().filter(x->x%2==0).collect(Collectors.toList());
        System.out.println(list2);
    }
}
