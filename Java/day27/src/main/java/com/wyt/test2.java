package com.wyt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class test2 {
    public static void main(String[] args) {
        ArrayList<String> listA = new ArrayList<>();
        listA.add("张三,24");
        listA.add("王五,45");
        listA.add("赵六,22");
        listA.add("李四,30");

        // 过滤并打印年龄 >= 24 的人员
        listA.stream()
                .filter(s -> Integer.parseInt(s.split(",")[1]) >= 24)
                .forEach(System.out::println);

        // 或者收集到新的列表中
        List<String> filteredList = listA.stream()
                .filter(s -> Integer.parseInt(s.split(",")[1]) >= 24)
                .toList();

        System.out.println("过滤后的列表: " + filteredList);
        Map<String, Integer> map=listA.stream()
                .filter(s -> Integer.parseInt(s.split(",")[1]) >= 24)
                .collect(Collectors.toMap(s -> s.split(",")[0], s -> Integer.parseInt(s.split(",")[1])));
        System.out.print(map);
    }
}