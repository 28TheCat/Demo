package org.example.多手多发;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds=new DatagramSocket();
        byte[] bytes=new byte[1024];
        Scanner sc=new Scanner(System.in);
        while (true){
            String temp=sc.nextLine();
            if(temp.equals("stop")){
                System.out.println("程序结束");
                return;
            }
            bytes=temp.getBytes();
            DatagramPacket dp=new DatagramPacket(bytes,bytes.length, InetAddress.getByName("192.168.1.66"),22222);
            ds.send(dp);
        }
    }
}
