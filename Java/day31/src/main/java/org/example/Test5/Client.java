package org.example.Test5;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds=new DatagramSocket();
        byte[] bytes="saki,saki,saki,saki".getBytes();
        DatagramPacket datagramPacket=new DatagramPacket(bytes,bytes.length, InetAddress.getByName("127.0.0.1"),10086);
        ds.send(datagramPacket);
        ds.close();

    }
}
