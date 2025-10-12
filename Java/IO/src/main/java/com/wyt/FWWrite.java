package com.wyt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FWWrite {
    public static void main(String[] args) throws IOException {
        FileWriter fw=new FileWriter("src/d.txt"); // 1. 创建字符输出流（覆盖模式）
        fw.write("刷");                             // 2. 把字符写到缓冲区
        fw.flush();                                // 3. 手动刷新，把缓冲区写入文件
        fw.write("新");                             // 4. 再写入“新”（在缓冲区里）
        fw.write("学");                             // 5. 再写入“学”
        fw.close();                                // 6. 关闭流，自动 flush 并释放资源

    }
}
