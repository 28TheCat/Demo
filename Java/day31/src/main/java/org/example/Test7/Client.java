package org.example.Test7;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",10001);
        OutputStream os = socket.getOutputStream();
        os.write("美味小祥".getBytes());
        os.close();
        socket.close();
    }
}
