package org.example.day3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10000); // 服务端绑定 10000 端口

        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);

        System.out.println("服务端已启动，等待接收数据...");

        ds.receive(dp);

        String received = new String(dp.getData(), 0, dp.getLength());
        System.out.println("服务端接收到的数据: " + received);

        ds.close();
    }
}
