package com.wyt;

import java.io.FileNotFoundException;

import static com.wyt.ThrowsDemo.read;

public class TryCatchDemo {
    public static void main(String[] args) {
        try {
            read("dasfl.txt");

        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    public static void read(String str)throws FileNotFoundException{
        if(!str.equals("dasfl.txt")){
            throw new FileNotFoundException("文件不存在");
        }
    }
}
