package com.wyt;

import java.io.File;

public class test1 {
    public static void main(String[] args) throws  Exception{
       File f=new File("aaa");
       f.mkdir();
       File f2=new File("aaa\\a.txt");
       f2.createNewFile();
       System.out.println(f2.exists());
        String[] name = f.list();
        for(String name1 : name){
            System.out.println(name1);
        }
        File[] names=f.listFiles();
        for(File name2:names){
            System.out.println(name2);
        }
    }
}
