package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

public class ServerRunnable implements Runnable {

    private Socket socket;
    private Properties properties;

    public ServerRunnable(Socket socket, Properties properties) {
        this.socket = socket;
        this.properties = properties;
    }

    @Override
    public void run() {
        try {
            // 为当前客户端创建输入输出流
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while (true) {
                String command = reader.readLine();
                if (command == null) break;

                switch (command) {
                    case "login" -> login(reader, writer);
                    case "register" -> register(reader, writer);
                    default -> writer.write("未知命令");
                }
                writer.newLine();
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 移除客户端，关闭 socket
            Server.list.remove(socket);
            try {
                if (!socket.isClosed()) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 登录
    private void login(BufferedReader reader, BufferedWriter writer) throws IOException {
        String userInfo = reader.readLine(); // username=xxx&password=xxx
        String[] arr = userInfo.split("&");
        String username = arr[0].split("=")[1];
        String password = arr[1].split("=")[1];

        if (properties.containsKey(username)) {
            String correctPassword = properties.getProperty(username);
            if (password.equals(correctPassword)) {
                writer.write("1"); // 登录成功
                writer.newLine();
                writer.flush();

                Server.list.add(socket); // 加入在线列表
                talk2All(reader, username);
            } else {
                writer.write("2"); // 密码错误
                writer.newLine();
                writer.flush();
            }
        } else {
            writer.write("3"); // 用户不存在
            writer.newLine();
            writer.flush();
        }
    }

    // 注册占位
    private void register(BufferedReader reader, BufferedWriter writer) throws IOException {
        writer.write("注册功能暂未实现");
        writer.newLine();
        writer.flush();
    }

    // 广播消息
    private void talk2All(BufferedReader reader, String username) throws IOException {
        String msg;
        while ((msg = reader.readLine()) != null) {
            String fullMsg = username + " 说：" + msg;
            System.out.println(fullMsg);

            for (Socket s : Server.list) {
                if (s.isClosed()) continue;
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                bw.write(fullMsg);
                bw.newLine();
                bw.flush();
            }
        }
    }
}
