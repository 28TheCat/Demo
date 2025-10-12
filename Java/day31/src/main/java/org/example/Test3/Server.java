package org.example.Test3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10000);
        Socket s = ss.accept();
        File file = new File("src/main/IMG/TCP代码细节1.png");
        BufferedInputStream bis = new BufferedInputStream(
                s.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(file));
        int len;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1){
            bos.write(bytes,0,len);
        }
        bos.flush();
        s.shutdownOutput();
        bis.close();
        bos.close();
    }
}
