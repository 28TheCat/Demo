package com.wyt;

import java.util.ArrayList;
import java.util.List;

public class demo5 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>(List.of("张三丰","张无忌","张翠山","王二麻子","张良","谢广坤"));
        list1.stream().filter(s -> s.startsWith("张")).forEach(System.out::println);
    }
}
