package com.wyt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferdDemo {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        try (
                FileInputStream fis = new FileInputStream("src/a.txt");
                FileOutputStream fos = new FileOutputStream("src/b.txt")
        ) {
            byte[] buffer = new byte[8192]; // 8KB 缓冲区
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + " ms");
    }
}
