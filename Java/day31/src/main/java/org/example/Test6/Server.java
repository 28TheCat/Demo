package org.example.Test6;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        System.out.println("服务器启动，等待客户端连接...");

        Socket socket = ss.accept();
        System.out.println("客户端已连接: " + socket.getInetAddress());

        InputStream is = socket.getInputStream();
        int len;
        while ((len = is.read()) != -1) {
            System.out.print((char) len);
        }

        socket.close();
        ss.close();
    }
}
