package org.example.server;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    public static List<Socket> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);

        Properties properties = new Properties();
        File file = new File("src/main/java/src/user.txt");

        if(file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            properties.load(fis);
            fis.close();
        } else {
            file.createNewFile();
        }

        while(true) {
            Socket socket = serverSocket.accept();
            System.out.println("客户端有连接");
            new Thread(new ServerMyRunnable(socket, properties)).start();
        }
    }
}
