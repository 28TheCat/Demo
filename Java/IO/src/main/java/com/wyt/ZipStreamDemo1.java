package com.wyt;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipStreamDemo1 {
    public static void main(String[] args) throws IOException {
        File src=new File("src/ZipStreamDemo1.zip");
        File dest=new File("src/ZipStreamDemo1");
        unzip(src,dest);
    }

    private static void unzip(File src, File dest) {
        ZipInputStream zip= null;
        try {
            zip = new ZipInputStream(new FileInputStream(src));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ZipEntry entry;
        try {
            while ((entry = zip.getNextEntry()) != null) {
                File file = new File(dest, entry.getName());
                if (entry.isDirectory()) {
                    file.mkdirs();
                } else {
                    File parent = file.getParentFile();
                    if (!parent.exists()) {
                        parent.mkdirs();
                    }
                    try (FileOutputStream fos = new FileOutputStream(file)) {
                        int b;
                        while ((b = zip.read()) != -1) {
                            fos.write(b);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
