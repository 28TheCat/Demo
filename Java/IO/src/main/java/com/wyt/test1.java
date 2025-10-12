package com.wyt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class test1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("src/2.jpg");
        FileInputStream fis=new FileInputStream("src/HashMap源码超详细讲解.jpg");
        int c;
        while ((c=fis.read())!=-1){
            fos.write(c);
        }
        fos.close();
        fis.close();
    }
}
