package com.wyt;

import java.io.*;

public class test3 {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("src/a.txt");
        File destFile = new File("src/a_encrypted.txt"); // 输出新文件
        encryptFile(srcFile, destFile);
        File srcFile2 = new File("src/c.txt");
        decryptFile(destFile, srcFile2);
    }
    public static void decryptFile(File src, File dest) throws IOException {
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b ^ 2);
            }
        }
    }

    public static void encryptFile(File src, File dest) throws IOException {
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {

            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b ^2); // 每个字节 +1
            }
        }
    }
}
