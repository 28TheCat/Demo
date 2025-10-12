package com.wyt;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class test6 {
    public static void main(String[] args) {
        try (
                BufferedReader bf = new BufferedReader(new FileReader("src/test6.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("src/test6_1.txt"))
        ) {
            String line;
            ArrayList<String> str = new ArrayList<>();

            while ((line = bf.readLine()) != null) {
                str.add(line);
            }
            Collections.sort( str);

            for (String s : str) {
                bw.write(s);
                bw.newLine();
            }
            bw.close();
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}