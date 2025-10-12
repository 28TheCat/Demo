package org.example.Test6;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // ✅ 端口号要和服务端一致
        Socket socket = new Socket("127.0.0.1", 10086);
        OutputStream os = socket.getOutputStream();

        os.write("hello,server".getBytes());

        os.close();
        socket.close();
    }
}
