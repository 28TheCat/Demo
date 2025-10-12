package org.example.day3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        byte[] b = "hello".getBytes();

        DatagramPacket dp = new DatagramPacket(b, b.length, InetAddress.getLocalHost(), 10086);

        ds.send(dp);


        ds.close();

        System.out.println("发送成功");
    }
}
