package org.example.day3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(); // 客户端不需要固定端口，可以自动分配

        String data = "hello";
        byte[] buf = data.getBytes();

        // 发送到服务端 127.0.0.1:10000
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, inetAddress, 10000);

        ds.send(sendPacket);
        System.out.println("客户端已发送数据: " + data);

        ds.close();
    }
}
