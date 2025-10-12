package com.wyt;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileOutputStreamConstructor {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("src/a.txt");
        FileOutputStream fos2=new FileOutputStream("src/c.txt",true);
        fos.write(97);
        fos.write(98);
        fos.write(99);
        fos.write(100);
        FileReader fr=new FileReader("src/a.txt");
        int c;
        while ((c=fr.read())!=-1){
            System.out.println((char)c);

        }
        fos.close();

    }

}
