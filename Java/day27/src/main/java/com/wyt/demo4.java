package com.wyt;

import java.util.ArrayList;
import java.util.Arrays;

public class demo4 {
    public static void main(String [] args){
        ArrayList<String> list=new ArrayList<>();
        list.addAll(Arrays.asList(
                "张三", "李四", "王五", "赵六", "钱七",
                "刘伟", "陈芳", "杨洋", "黄敏", "周杰",
                "吴军", "郑丽", "何娜", "郭涛", "林静",
                "徐勇", "孙艳", "高磊", "马娟", "胡明","张的人"
        ));

        ArrayList<String> list2=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            String s=list.get(i);
            if(s.charAt(0)=='张'&&s.length()>2){
                list2.add(list.get(i));
            }
        }
        System.out.println(list2);
    }
}
