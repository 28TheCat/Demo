package com.wyt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list,
                "张伟", "李娜", "王强", "赵敏", "孙浩",
                "周洁", "吴磊", "郑爽", "陈刚", "刘芳",
                "杨洋", "何丽", "郭鹏", "高翔", "林雪",
                "马超", "胡静", "曹雷", "范晨", "宋媛"
        );
        shuffle(list);
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
            if(i==list.size()-1){
                System.out.println("已经点完名了，请重启重新点名");
            }
        }
    }
    public static void shuffle(ArrayList<String> list){
        int n = list.size();
        for (int i = 0; i < n; i++){
            int r = i + (int)(Math.random() * (n-i));
            String temp = list.get(i);
            list.set(i, list.get(r));
            list.set(r, temp);
        }
    }
}
