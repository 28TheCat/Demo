package com.wyt;

import java.io.*;

public class ReaderDemo2 {
    public static void main(String[] args) throws IOException {
        try (
                InputStreamReader fd1 = new InputStreamReader(new FileInputStream("src/ReaderDemo2.txt"));
                InputStreamReader fd2 = new InputStreamReader(new FileInputStream("src/ReaderDemo2_1.txt"), "GBK")
        ) {
            int read;
            while ((read = fd1.read()) != -1) {
                System.out.print((char) read);
            }
            System.out.println("\n======================================");
            while ((read = fd2.read()) != -1) {
                System.out.print((char) read);
            }
        } // 自动关闭
    }
}

