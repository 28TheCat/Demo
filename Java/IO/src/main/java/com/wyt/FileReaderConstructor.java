package com.wyt;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderConstructor {
    public static void main(String[] args) throws IOException {
        File file = new File("src/a.txt");

        // 方式1：通过 File 对象
        FileReader fd1 = new FileReader(file);

        // 方式2：直接传路径
        FileReader fd2 = new FileReader("src/a.txt");

        // 建议使用 try-with-resources 来避免资源泄漏
        try (FileReader fd = new FileReader(file)) {
            int c;
            while ((c = fd.read()) != -1) {
                System.out.print((char) c);
            }
        }
    }
}
