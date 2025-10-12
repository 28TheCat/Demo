package com.wyt;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test4 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src/a.txt");
        FileWriter fw = new FileWriter("src/b.txt");
        StringBuilder sb = new StringBuilder();
        int len;
        char[] ch = new char[1024];
        while ((len = fr.read(ch)) != -1) {
            sb.append(ch, 0, len);
        }

        // 把所有数字提取出来
        List<Integer> digits = new ArrayList<>();
        for (char c : sb.toString().toCharArray()) {
            if (Character.isDigit(c)) {
                digits.add(c - '0');
            }
        }

        Collections.sort(digits);

        int g = 0;
        for (char c : sb.toString().toCharArray()) {
            if (Character.isDigit(c)) {
                fw.write(String.valueOf(digits.get(g++)));
            } else {
                fw.write(c);
            }
        }

        fr.close();
        fw.close();
    }
}
