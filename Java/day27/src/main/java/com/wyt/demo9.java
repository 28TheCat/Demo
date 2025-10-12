package com.wyt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class demo9 {
    public static void main(String[] args) {
        // 男演员列表
        List<String> manList = new ArrayList<>();
        manList.add("周润发");
        manList.add("成龙");
        manList.add("刘德华");
        manList.add("吴京");
        manList.add("周星驰");
        manList.add("李连杰");

        // 女演员列表
        List<String> womanList = new ArrayList<>();
        womanList.add("林心如");
        womanList.add("张曼玉");
        womanList.add("林青霞");
        womanList.add("柳岩");
        womanList.add("林志玲");
        womanList.add("王祖贤");

        // 过滤男演员：名字为3个字的前三人
        List<String> filteredMen = manList.stream()
                .filter(s -> s.length() == 3)
                .limit(3)
                .collect(Collectors.toList());

        // 过滤女演员：姓林的，并且不要第一个
        List<String> filteredWomen = womanList.stream()
                .filter(s -> s.startsWith("林"))
                .skip(1)
                .collect(Collectors.toList());

        // 合并男女演员
        List<String> allFiltered = Stream.concat(filteredMen.stream(), filteredWomen.stream())
                .collect(Collectors.toList());

        // 创建 actor 对象并遍历
        List<actor> actors = allFiltered.stream()
                .map(actor::new)
                .collect(Collectors.toList());

        actors.forEach(actor::show);
    }
}
