package com.wyt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class test2 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/a");
        File file1 = new File("src/b");
        copy(file,file1);
    }
    public static void copy(File src,File dest) throws IOException{
      dest.mkdirs();
      File file[] = src.listFiles();
      for(File f : file){
          if(f.isFile()){
              FileInputStream fis = new FileInputStream(f);
              FileOutputStream fos = new FileOutputStream(new File(dest,f.getName()));
              byte[] b = new byte[1024];
              int len;
              while((len = fis.read(b)) != -1){
                  fos.write(b,0,len);
              }
              fis.close();
              fos.close();
          }
          else{

              copy(f,new File(dest,f.getName()));
          }

      }
    }
}
