package com.wyt;

import java.io.*;

public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(
                new FileInputStream("src/  OutputStreamWriter.txt"), "GBK"
        );

        OutputStreamWriter osw = new OutputStreamWriter(
                new FileOutputStream("  OutputStreamWriter_out.txt")
        );
        int ch;
        while ((ch = isr.read()) != -1) {
            System.out.print((char) ch);
            osw.write(ch);
        }
        isr.close();
        osw.close();
    }
}
