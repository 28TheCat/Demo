package com.wyt;

import java.io.FileInputStream;
import java.io.IOException;

public class FISRead {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src/d.txt");

        byte[] bytes = new byte[fis.available()]; // 获取文件大小，分配数组
        fis.read(bytes); // 把内容读进数组

        System.out.println(new String(bytes)); // 直接转换成字符串输出

        fis.close();
    }
}