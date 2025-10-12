package com.wyt;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        File f=new File("C:/aaa/bbb.java");
        System.out.println(f.getAbsoluteFile());
        System.out.println(f.getPath());
        System.out.println(f.getName());
        System.out.println(f.length());System.out.println(f.exists());
        File f2=new File("C:/ccc");
        System.out.println(f2.mkdir());
        System.out.println(f2.getAbsoluteFile());
        System.out.println(f2.getPath());
        System.out.println(f2.getName());
        System.out.println(f2.length());
    }
}
