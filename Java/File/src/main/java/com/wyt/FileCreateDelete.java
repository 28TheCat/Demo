package com.wyt;

import java.io.File;

public class FileCreateDelete {
    public static void main(String[] args) throws  Exception {
        File f=new File("aaa.txt");
        System.out.println("是否存在"+f.exists());
        System.out.println("是否创建"+f.createNewFile());
        System.out.println("是否存在"+f.exists());
        System.out.println("是否删除"+f.delete());
        System.out.println("是否存在"+f.exists());

    }
}
