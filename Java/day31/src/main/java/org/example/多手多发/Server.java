package org.example.多手多发;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds=new DatagramSocket(22223);
        while (true){
            DatagramPacket dp=new DatagramPacket(new byte[1024],1024);
            ds.receive(dp);
            System.out.println("收到数据: " + new String(dp.getData(),0,dp.getLength()));
        }
    }
}
