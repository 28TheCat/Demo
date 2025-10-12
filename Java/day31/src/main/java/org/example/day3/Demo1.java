package org.example.day3;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo1 {
    public static void main(String[] args) throws UnknownHostException {
        // 通过 IP 获取 InetAddress 对象
        InetAddress inetAddress = InetAddress.getByName("192.168.1.66");

        // 获取主机名
        String name = inetAddress.getHostName();

        // 获取 IP 地址
        String ip = inetAddress.getHostAddress();

        System.out.println("主机名: " + name);
        System.out.println("IP地址: " + ip);
    }
}
