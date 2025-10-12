package org.example.Demo12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",22222);
        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream("src/main/IMG/TCP代码细节.png"));
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(socket.getOutputStream());
        byte[] bytes=new byte[1024];
        int len;
        while ((len=bufferedInputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes,0,len);
            bufferedOutputStream.flush();
        }
        socket.shutdownOutput();
        BufferedOutputStream bos=new BufferedOutputStream(System.out);
        while ((len=socket.getInputStream().read(bytes))!=-1){
            bos.write(bytes,0,len);
            bos.flush();
        }
        bos.close();
        socket.close();
    }
}
