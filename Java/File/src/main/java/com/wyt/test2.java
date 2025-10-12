package com.wyt;

import java.io.File;

public class test2 {
    public static void main(String[] args) {
        File f=new File("aaa");
        if (haveAVI( f)){
            System.out.println(f.getName()+"存在avi");

        }
        else{
            System.out.println(f.getName()+"不存在");
        }
    }
    public static boolean haveAVI(File f){
        File[] files=f.listFiles();
        for (File file:files){
            if (file.getName().endsWith(".avi")){
                System.out.println(file.getName());
                return true;
            }
        }
        return false;
    }
}
