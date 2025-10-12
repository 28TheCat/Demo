package com.wyt;

import com.sun.security.jgss.GSSUtil;

import java.io.*;

public class BuffeeredReaderDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("src/b.txt"));
        BufferedWriter bw=new BufferedWriter(new FileWriter("src/b.txt"));
        String line;
        while ((line=br.readLine())!=null){
            System.out.println(line);
            System.out.println("=========================");
            bw.newLine();
            bw.write("dfldsjjjjjjjjjjjjjjjajflsdjf");
            System.out.println(line);
        }
        br.close();
        bw.close();
    }
}
