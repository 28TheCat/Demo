package org.example.Test5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Server2 {
    public static void main(String[] args) throws IOException {
        MulticastSocket ms=new MulticastSocket(10086);
        DatagramPacket dp=new DatagramPacket(new byte[1024],1024);
        ms.joinGroup(InetAddress.getByName("224.0.0.1"));
        ms.receive(dp);
        byte[] bytes=dp.getData();
        System.out.println(new String(bytes,0,dp.getLength()));
        ms.close();
    }
}
