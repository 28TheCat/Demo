package org.example.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // 这里要改成服务端的 IP
        Socket s = new Socket("127.0.0.1", 10087);

        OutputStream os = s.getOutputStream();
        os.write("hello, server".getBytes());

        os.close();
        s.close();
    }
}
