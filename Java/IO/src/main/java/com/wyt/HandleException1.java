package com.wyt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HandleException1 {
    public static void main(String[] args) throws IOException {
        FileWriter fw=null;
       try{
           fw=new FileWriter("src/d.txt");
           fw.write("黑马程序员");
       }catch(IOException e){
           e.printStackTrace();
       }finally {
           try {
               if(fw!=null){
                   System.out.printf("我要关闭了");
                   fw.close();
               }
               else {
                   System.out.printf("fw为null");
               }
           }catch (Exception e){
               e.printStackTrace();
           }
       }
    }
}
