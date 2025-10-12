package com.wyt;

import java.util.*;

import static java.util.Collections.shuffle;

public class test1 {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        Collections.addAll(students,
                "张伟", "李娜", "王强", "赵敏", "孙浩",
                "周洁", "吴磊", "郑爽", "陈刚", "刘芳",
                "杨洋", "何丽", "郭鹏", "高翔", "林雪",
                "马超", "胡静", "曹雷", "范晨", "宋媛"
        );
//        Random r=new Random();
//        System.out.println(students.get(r.nextInt(students.size())));
        shuffle(students);
        System.out.println(students.get(0));
    }
}
