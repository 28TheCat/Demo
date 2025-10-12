package com.wyt;

import java.io.File;

public class Filefor {
    public static void main(String[] args) {
        File f = new File("C:/aaa");

// 1. 获取目录下的所有子文件/子目录的名字（String 数组）
        String[] name = f.list();
        for(String name1: name){
            System.out.println(name1);  // 只打印名字
        }

// 2. 获取目录下的所有子文件/子目录对象（File 数组）
        File[] files = f.listFiles();
        for(File file: files){
            System.out.println(file.getName());  // 这里也只打印名字
        }

    }

}
