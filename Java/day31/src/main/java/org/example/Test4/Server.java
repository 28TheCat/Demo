package org.example.Test4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        // 1. 创建服务器端Socket，监听端口
        ServerSocket serverSocket = new ServerSocket(10000);
        System.out.println("服务器已启动，等待客户端连接...");

        // 2. 等待客户端连接
        Socket socket = serverSocket.accept();
        System.out.println("客户端已连接：" + socket.getInetAddress().getHostAddress());

        // 3. 准备要发送的文件
        File file = new File("src/main/IMG/TCP代码细节.png");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));

        // 4. 获取输出流，准备传输
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        // 5. 边读边写
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        // 6. 刷新、关闭资源
        bos.flush();
        System.out.println("文件发送完成！");

        bis.close();
        bos.close();
        socket.close();
        serverSocket.close();
    }
}
