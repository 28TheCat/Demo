package com.wyt;

import java.io.FileNotFoundException;

public class ThrowsDemo {
    public static void main(String[] args) throws FileNotFoundException {
        read("a23423.text");

    }
    public static void read(String path) throws FileNotFoundException{
        if(!path.equals("a.text")){
            throw new FileNotFoundException("文件不存在");
        }
    }
}
