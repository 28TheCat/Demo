package org.example.Demo12;

import org.example.day2.MyRunnable;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(22222);
        System.out.println("连接成功");
        while ( true){
            Socket socket=ss.accept();
            new Thread(new MyRunnale(socket)).start();
        }
    }
}
