package com.wyt;

import java.util.*;
import java.util.stream.Stream;

public class demo6 {
    public static void main(String[] args) {
        List<String> list1 = List.of("张三丰","张无忌","张翠山","王二麻子","张良","谢广坤");
        Stream<String> stream = list1.stream();
        Set< String> set=new HashSet<>();
        Stream<String> setStream = set.stream();

        Map<String,Integer> map=new HashMap<>();
        Stream<String> keyStream = map.keySet().stream();
        Stream<Integer> valueStream = map.values().stream();
        Stream<Map.Entry<String,Integer>> entryStream = map.entrySet().stream();

        String[] strArray={"hello","world","fuck"};
        Stream<String> strArrayStream = Arrays.stream(strArray);
        Stream<String> strArrayStream1 = Stream.of(strArray);
        Stream<String> strArrayStream2 = Stream.of("hello","world","fuck");


    }
}
