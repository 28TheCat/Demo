package com.wyt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class test4 {
    public static void main(String[] args) {
        ArrayList<String> list2 = new ArrayList<String>();
        Collections.addAll(list2,
                "张伟", "李娜", "王强", "赵敏", "孙浩",
                "周洁", "吴磊", "郑爽", "陈刚", "刘芳",
                "杨洋", "何丽", "郭鹏", "高翔", "林雪",
                "马超", "胡静", "曹雷", "范晨", "宋媛"
        );
        int n=list2.size();
        ArrayList<String> list3 = new ArrayList<String>();
        Random r=new Random();
        for (int i=0;i<10;i++){
            System.out.println("=========这是第"+i+"轮点名========");
            for(int j=0;j<n;j++){
                int a=r.nextInt(list2.size());
                System.out.println(list2.get(a));

                list3.add(list2.get(a));
                list2.remove( a);
            }
            list2.addAll(list3);
            list3.clear();
        }
    }
}
