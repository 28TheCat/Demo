package com.wyt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterConstructor {
    public static void main(String[] args) throws IOException {
        FileWriter fw=new FileWriter("src/d.txt",true);
        fw.write("abcde");
        fw.close();
    }
}
