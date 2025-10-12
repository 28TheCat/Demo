package com.wyt;

import java.io.File;
import java.io.FileFilter;

public class FileIs {
    public static void main(String[] args) {
        File f=new File("C:/aaa/bbb.java");
        System.out.println(f.isFile());
        File f2=new File("C:/aaa");
        System.out.println(f.exists());
    }
}
