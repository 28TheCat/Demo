package com.wyt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

public class FOSWrite {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos=new FileOutputStream("src/b.txt");
        byte[] b="黑马程序员".getBytes();
        for(byte b1:b){
            fos.write(b1);
        }
        FileReader fr=new FileReader("src/b.txt");
        int c;
        while ((c=fr.read())!=-1){
            System.out.println((char)c);
        }
        fos.close();
        fr.close();
    }
}
