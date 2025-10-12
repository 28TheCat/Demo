package com.wyt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static java.util.Collections.shuffle;

public class test2 {
    public static void main(String[] args) {
        // 男生姓名
        ArrayList<String> mStudents = new ArrayList<>();
        Collections.addAll(mStudents,
                "张伟", "王强", "孙浩", "吴磊", "陈刚",
                "杨洋", "郭鹏", "高翔", "马超", "曹雷"
        );

        // 女生姓名
        ArrayList<String> fStudents = new ArrayList<>();
        Collections.addAll(fStudents,
                "李娜", "赵敏", "周洁", "郑爽", "刘芳",
                "何丽", "林雪", "胡静", "范晨", "宋媛"
        );


            Random r=new Random();
            int a=r.nextInt(10);
            System.out.println(a);

        if (a<=2){
            shuffle(fStudents);
            System.out.println(fStudents.get(0));
        }
        else{
            shuffle(mStudents);
            System.out.println(mStudents.get(0));

        }

    }
}
