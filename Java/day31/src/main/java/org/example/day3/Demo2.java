package org.example.day3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10086);
        DatagramSocket ds2 = new DatagramSocket(10087);

        // 1. 发送
        byte[] sendData = "hello".getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getLocalHost(), 10087);
        ds.send(sendPacket);

        // 2. 接收
        byte[] buf = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
        ds2.receive(receivePacket);

        String data = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("ds2接收到的数据: " + data);

        ds.close();
    }
}

