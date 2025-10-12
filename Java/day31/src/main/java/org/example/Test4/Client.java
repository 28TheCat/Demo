package org.example.Test4;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class Client {
    public static void main(String[] args) throws IOException {
        // 1. 连接服务器
        Socket socket = new Socket("127.0.0.1", 10000);
        System.out.println("客户端连接成功，开始接收数据...");

        // 2. 输入流（从服务器读取数据）
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

        // 3. 输出流（保存到本地文件）
        UUID uuid = UUID.randomUUID();
        File file = new File("src/main/IMG/"+uuid.toString().replace("-", "")+".png");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));

        // 4. 读写循环
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        // 5. 刷新并关闭资源
        bos.flush();
        bos.close();
        bis.close();
        socket.close();

        System.out.println("文件接收完成，客户端退出。");
    }
}
