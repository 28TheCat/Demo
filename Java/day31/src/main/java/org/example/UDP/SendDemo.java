package org.example.UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class SendDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        while (true) {
            String msg = sc.nextLine(); // 输入的字符串
            if ("886".equals(msg)) {   // 判断是否退出
                System.out.println("退出发送...");
                break;
            }

            byte[] bytes = msg.getBytes();
            DatagramPacket dp = new DatagramPacket(
                    bytes,
                    bytes.length,
                    InetAddress.getByName("192.168.1.66"), // 目标 IP
                    12345                                // 目标端口
            );
            ds.send(dp);
        }

        ds.close();
    }
}
