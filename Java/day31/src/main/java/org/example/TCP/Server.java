package org.example.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动中，等待客户端连接...");

        ServerSocket ss = new ServerSocket(10087);
        Socket s = ss.accept(); // 阻塞，等待客户端连接

        System.out.println("客户端连接成功！");
        System.out.println("客户端的地址是：" + s.getInetAddress().getHostAddress());

        InputStream is = s.getInputStream();
        int b;
        while ((b = is.read()) != -1) {
            System.out.print((char) b);
        }

        s.close();
        ss.close();
    }
}
