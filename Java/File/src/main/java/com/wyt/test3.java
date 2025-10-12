package com.wyt;

import java.io.File;

public class test3 {
    public static void main(String[] args) {
        File f = new File("aaa"); // 可以改成你要搜索的目录
        if (haveAVI(f)) {
            System.out.println(f.getName() + " 存在 avi 文件");
        } else {
            System.out.println(f.getName() + " 不存在 avi 文件");
        }
    }

    public static boolean haveAVI(File f) {
        int flag=0;
        if (f == null || !f.exists() || !f.isDirectory()) {
            return false;
        }

        File[] files = f.listFiles();
        if (files == null) return false;

        for (File file : files) {
            if (file.isFile() && file.getName().toLowerCase().endsWith(".avi")) {
                System.out.println(file.getAbsolutePath()); // 打印找到的文件
                flag=1;

            } else if (file.isDirectory()) {
                // 递归子目录
                if (haveAVI(file)) return true;
            }
        }
        if(flag==1)
        return true;
        return false;
    }
}
