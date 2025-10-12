package com.wyt;

import java.io.FileWriter;
import java.io.IOException;

public class FWWrite2 {
    public static void main(String[] args) throws IOException {
        FileWriter fw=new FileWriter("src/d.txt",true);
        char[] ch="28喵喵喵".toCharArray();
        fw.write(ch);
        fw.write("\r\nhello");
        fw.write(ch,0,3);
        fw.close();
    }
}
