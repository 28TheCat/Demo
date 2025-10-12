package org.example.Demo11;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(22222);
        Socket socket=ss.accept();
        System.out.println("连接成功");
        File file=new File("src/main/IMG/Demo11.png");
        FileOutputStream fos=new FileOutputStream(file);
        byte[] bytes=new byte[1024];
        int len;
        while ((len=socket.getInputStream().read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        socket.shutdownInput();
        fos.close();
        socket.close();
        ss.close();

        System.out.println("接收成功");
    }
}
