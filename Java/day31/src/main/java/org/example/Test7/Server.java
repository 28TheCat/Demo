package org.example.Test7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);
        System.out.println("服务器启动");
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String len;
        while ((len = br.readLine()) != null) {
            System.out.print( len);
        }
        ss.close();
        is.close();
    }
}
