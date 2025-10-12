package org.example.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        // 接收端绑定端口 12345，必须和发送端一致
        DatagramSocket ds = new DatagramSocket(12345);

        byte[] bytes = new byte[1024];

        while (true) {
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            ds.receive(dp); // 接收数据

            // 转换成字符串
            String msg = new String(dp.getData(), 0, dp.getLength());
            System.out.println("收到消息: " + msg);
        }
    }
}