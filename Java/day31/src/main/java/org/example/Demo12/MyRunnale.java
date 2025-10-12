package org.example.Demo12;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class MyRunnale implements Runnable {
    private Socket socket;

    public MyRunnale(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            UUID uuid = UUID.randomUUID();
            // 接收文件
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream("src/main/IMG/" + uuid.toString().replace("-", "") + ".png")
            );

            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            bos.flush();
            bos.close();
            bis.close();

            // 回复客户端
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("上传成功");
            bw.newLine();
            bw.flush();  // 注意flush
            bw.close();

            socket.close();
            System.out.println("文件接收完成，客户端通知已发送");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}