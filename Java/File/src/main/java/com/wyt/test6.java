package com.wyt;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class test6 {
    public static void main(String[] args) {
        File f = new File("src/daf");
        Map<String, Integer> map = new HashMap<>();
        map.put("txt", find(f, "txt"));
        map.put("doc", find(f, "doc"));
        map.put("jpg", find(f, "jpg"));
        System.out.println("txt 文件数量: " + map.get("txt"));
        System.out.println("doc 文件数量: " + map.get("doc"));
        System.out.println("jpg 文件数量: " + map.get("jpg"));
    }

    public static int find(File f, String name) {
        if (f == null || !f.exists()) return 0;

        int count = 0;

        // 如果是文件，检查后缀
        if (f.isFile()) {
            if (f.getName().toLowerCase().endsWith(name.toLowerCase())) {
                return 1;
            } else {
                return 0;
            }
        }

        // 如果是目录，递归遍历子文件
        File[] files = f.listFiles();
        if (files == null) return count; // 空目录或不可访问

        for (File file : files) {
            count += find(file, name);
        }
        return count;
    }
}
