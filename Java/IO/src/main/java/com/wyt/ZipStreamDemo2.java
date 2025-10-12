package com.wyt;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipStreamDemo2 {
    public static void main(String[] args) throws IOException {
        File src = new File("src/ZipStreamDemo2");   // 要压缩的目录
        File dest = new File("src/ZipStreamDemo2.zip");        // 压缩包目标文件
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest))) {
            zip(src, zos, src.getName() + "/");      // 传递相对路径前缀
        }
    }

    // 递归压缩
    public static void zip(File src, ZipOutputStream zos, String base) throws IOException {
        File[] files = src.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isFile()) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    // 保持目录层级
                    zos.putNextEntry(new ZipEntry(base + file.getName()));
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = fis.read(buffer)) != -1) {
                        zos.write(buffer, 0, len);
                    }
                    zos.closeEntry();
                }
            } else {
                // 递归处理子目录
                zip(file, zos, base + file.getName() + "/");
            }
        }
    }
}
