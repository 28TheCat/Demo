package org.example.Demo11;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",22222);
        OutputStream os=socket.getOutputStream();
        File file=new File("src/main/IMG/TCP代码细节.png");
        FileInputStream fis=new FileInputStream(file);
        BufferedInputStream bis=new BufferedInputStream(fis);
        BufferedOutputStream bos=new BufferedOutputStream(socket.getOutputStream());
        byte[] bytes=new byte[1024];
        int len;
        while ((len=bis.read(bytes))!=-1 ){
            bos.write(bytes,0,len);
            bos.flush();
        }

        socket.shutdownOutput();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = br.readLine();
        System.out.println(line);
        bis.close();
        bos.close();
    }
}
