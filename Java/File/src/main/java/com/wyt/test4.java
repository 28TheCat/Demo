package com.wyt;

import java.io.File;

public class test4 {
    public static void main(String[] args) {
        File f=new File("aaa");
        if (f.exists()){
            System.out.println(f.getName()+"存在");
        }
        else{
            System.out.println(f.getName()+"不存在");
        }
        delect(f);
        if (f.exists()){
            System.out.println(f.getName()+"存在");
        }
        else{
            System.out.println(f.getName()+"不存在");
        }
    }
    public static void delect(File f){
        File[] files=f.listFiles();
        for (File file:files){
            if (!file.isDirectory()){
                file.delete();
            }else {
                delect(file);
            }
        }
        f.delete();
    }
}
