package com.wyt;

import java.io.FileReader;
import java.io.IOException;

public class ReaderDemo {
    public static void main(String[] args) throws IOException {
        try (FileReader fd = new FileReader("src/ReaderDemo.txt")) {
            int c;
            while ((c = fd.read()) != -1) {
                char ch = (char) c;
                System.out.print((char)ch);
            }
        }
    }
}