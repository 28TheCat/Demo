package com.wyt;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class test5 {
    public static void main(String[] args) throws IOException {
        Map<Integer, String> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/a.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("src/b.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\.");
                if (parts.length >= 2) {
                    int key = Integer.parseInt(parts[0]);
                    String value = parts[1]; // 点号后的内容
                    map.put(key, value);
                }
            }

            for (int i = 1; i <= map.size(); i++) {
                bw.write(i + "." + map.get(i));
                bw.newLine();
            }
        }
    }
}
