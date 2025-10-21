package org.example.client;

import java.io.*;
import java.net.Socket;

public class ClientMyRunnable implements Runnable {
        private final Socket socket;

        public ClientMyRunnable(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String msg;
                while ((msg = br.readLine()) != null) {
                    System.out.println(msg);
                }
            } catch (IOException e) {
                System.out.println("服务器断开连接");
            }
        }
    }
