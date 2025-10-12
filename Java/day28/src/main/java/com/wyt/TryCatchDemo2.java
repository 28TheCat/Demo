package com.wyt;

import java.io.FileNotFoundException;

import static com.wyt.ThrowsDemo.read;

public class TryCatchDemo2 {
    public static void main(String[] args) {
        try{
            read("dasf32l.txt");
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("程序结束");
        }
        System.out.println("程序继续执行");
    }
    public static void read(String str)throws FileNotFoundException{
        if(!str.equals("dasfl.txt")){
            throw new FileNotFoundException("文件不存在");
        }
    }
}
