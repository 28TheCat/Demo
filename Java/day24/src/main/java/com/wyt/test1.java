package com.wyt;

import java.util.*;

public class test1 {

//    // 牌面对应的数值
//
//
//    public static void main(String[] args) {
//        // 扑克牌点数
//        ArrayList<String> ting = new ArrayList<>(Arrays.asList(
//                "A", "2", "3", "4", "5", "6", "7",
//                "8", "9", "10", "J", "Q", "K"
//        ));
//        // 扑克牌花色
//        ArrayList<String> shun = new ArrayList<>(Arrays.asList("♦", "♣", "♥", "♠"));
//
//        // 生成整副牌
//        ArrayList<String> pai = new ArrayList<>();
//        for (String t : ting) {
//            for (String s : shun) {
//                pai.add(s + t);
//            }
//        }
//        pai.add("小王");
//        pai.add("大王");
//
//        // 洗牌
//        Collections.shuffle(pai);
//
//        // 三个玩家和底牌
//        ArrayList<String> you = new ArrayList<>();
//        ArrayList<String> di = new ArrayList<>();
//        ArrayList<String> zi = new ArrayList<>();
//        ArrayList<String> dipai = new ArrayList<>();
//
//        // 发牌（最后三张做底牌）
//        for (int i = 0; i < pai.size(); i++) {
//            String card = pai.get(i);
//            if (i >= pai.size() - 3) {
//                dipai.add(card);
//            } else if (i % 3 == 0) {
//                you.add(card);
//            } else if (i % 3 == 1) {
//                di.add(card);
//            } else {
//                zi.add(card);
//            }
//        }
//
//        // 排序玩家手牌
//        order(you);
//        order(di);
//        order(zi);
//        order(dipai);
//
//        // 打印结果
//        printPoker(you, "你");
//        printPoker(di, "底");
//        printPoker(zi, "自");
//        printPoker(dipai, "底牌");
//    }
//
//    // 打印手牌
//    public static void printPoker(ArrayList<String> poker, String name) {
//        System.out.print(name + "的牌是：");
//        for (String s : poker) {
//            System.out.print(s + " ");
//        }
//        System.out.println();
//    }

}
