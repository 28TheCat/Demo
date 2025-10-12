package com.wyt;

import java.util.ArrayList;

public class demo7 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三丰");
        list.add("张无忌");
        list.add("张翠山");
        list.add("王二麻子");
        list.add("张良");
        list.add("谢广坤");
       list.stream().filter(s -> s.startsWith("张")).forEach(System.out::println);
       list.stream().skip(2).limit(4).forEach(System.out::println);

    }
}
