package com.wyt;

import java.io.FileOutputStream;
import java.io.IOException;

public class FosWrite2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("src/d.txt");
        byte[] bytes = "abc1de".getBytes();
        fos.write( bytes,2,3);
        fos.close();
    }
}
