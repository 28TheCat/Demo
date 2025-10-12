package com.wyt;

import java.io.IOException;
import java.io.PrintStream;

public class PrintDemo {
    public static void main(String[] args) throws IOException {
        System.out.println(97);
        PrintStream ps=new PrintStream("src/ps.txt");
        System.setOut(ps);
        System.out.println(971);
    }
}
