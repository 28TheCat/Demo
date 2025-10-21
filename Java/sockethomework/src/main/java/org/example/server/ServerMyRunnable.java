package org.example.server;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.*;

public class ServerMyRunnable implements Runnable {
    private final Socket socket; // 每个线程独立的 socket
    private final Properties properties; // 可共享的用户数据
    public static List < Socket > list = new ArrayList < > ();

    public ServerMyRunnable(Socket socket, Properties properties) throws IOException {
        this.socket = socket;
        this.properties = properties;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = bufferedReader.readLine();
            System.out.println(line);
            switch (line) {
                case "login":
                    login(bufferedReader);
                    break;
                case "register":
                    register(bufferedReader);
                    break;
                default:
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void login(BufferedReader bufferedReader) throws IOException {
        System.out.println("登录");
        String userInfo = bufferedReader.readLine();
        if (userInfo == null || userInfo.isEmpty()) {
            System.out.println("未读取到用户信息！");
            return;
        }
        System.out.println("用户信息：" + userInfo);
        String[] userInfoArr = userInfo.split("&");
        String name = userInfoArr[0].split("=")[1];
        String password = userInfoArr[1].split("=")[1];
        System.out.println("用户名：" + name);
        System.out.println("密码：" + password);

        if (!(properties.containsKey(name))) {
            System.out.println("用户不存在");
            writeMessage2Client("2");
        } else {
            if (properties.getProperty(name).equals(password)) {
                System.out.println(name+"登录成功");

                writeMessage2Client("1");

                list.add(socket);

                talk2All(bufferedReader, name);

            } else {
                System.out.println(name+"登录失败");
                writeMessage2Client("3");
            }
        }
    }

    public void writeMessage2Client(String message) throws IOException {
        BufferedWriter bufferedWriter =
                new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write(message);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

    public void saveData(String userName, String message) {
        try {
            File logDir = new File("src/main/java/src/Data/chatlogs");
            if (!logDir.exists()) {
                logDir.mkdirs();
            }

            // 每个用户一个文件
            File logFile = new File(logDir, userName + ".txt");
            // 时间戳
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            // 追加写入
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
                writer.write("[" + time + "] " + userName + "：" + message);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void talk2All(BufferedReader br, String userName) throws IOException {
        String message;
        try {
            while ((message = br.readLine()) != null) {
                System.out.println(userName + "发送消息：" + message);

                // 保存聊天记录
                saveData(userName, message);

                // 群发消息
                synchronized(list) {
                    for (Socket s: list) {
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                        bw.write(userName + "：" + message);
                        bw.newLine();
                        bw.flush();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(userName + "下线了");
            synchronized(list) {
                list.remove(socket);
            }
        }
    }



    public void register(BufferedReader bufferedReader) throws IOException {
        System.out.println("注册");
        String userInfo = bufferedReader.readLine();
        if (userInfo == null || userInfo.isEmpty()) {
            System.out.println("未读取到用户信息！");
            return;
        }
        System.out.println("用户信息：" + userInfo);
        String[] userInfoArr = userInfo.split("&");
        String name = userInfoArr[0].split("=")[1];
        String password = userInfoArr[1].split("=")[1];
        System.out.println("用户名：" + name);
        System.out.println("密码：" + password);

        if (properties.containsKey(name)) {
            writeMessage2Client("3");
            System.out.println("用户已存在");
        } else if (name.matches("^[a-zA-Z]{6,18}$")) {
            writeMessage2Client("2");
            System.out.println("用户名格式错误");
        } else if (password.matches("^[a-zA-Z]\\d{2,7}$")) {
            writeMessage2Client("4");
            System.out.println("密码格式错误！第一位必须是字母，后面必须是纯数字");
        } else {
            writeMessage2Client("1");
            System.out.println("注册成功");
            System.out.println("注册成功");
            saveUser(name, password);

        }
    }
    private void saveUser(String name, String password) {
        synchronized(properties) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("user.properties", true))) {
                bw.write(name + "=" + password);
                bw.newLine();
                properties.setProperty(name, password);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}