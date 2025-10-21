package org.example.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Client {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 10000);
        System.out.println("服务器已连接");

        while (true) {
            sleep(1000);
            System.out.println("==============欢迎来到QQ聊天室================");
            System.out.println("1 登录");
            System.out.println("2 注册");
            System.out.println("请输入您的选择：");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("你选择了登录");
                    login(socket);
                    break;
                case 2:
                    System.out.println("你选择了注册");
                    register(socket);
                    break;
                default:
                    System.out.println("输入错误，请输入 1 或 2");
            }
        }
    }

    public static void login(Socket socket) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("请输入用户名：");
        scanner.nextLine();
        String name = scanner.next();

        System.out.println("请输入密码：");
        String password = scanner.next();

        bufferedWriter.write("login");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        StringBuilder sb = new StringBuilder();
        sb.append("username=").append(name).append("&password=").append(password);
        bufferedWriter.write(sb.toString());
        bufferedWriter.newLine();
        bufferedWriter.flush();

        String message = bufferedReader.readLine(); // 直接用已有的流
        System.out.println("服务端回复：" + message);

        if (message.equals("1")) {
            System.out.println("登录成功, 开始聊天");
            new Thread(new ClientMyRunnable(socket)).start();
            talk2All(bufferedWriter);
        } else if (message.equals("2")) {
            System.out.println("用户不存在");
        } else if (message.equals("3")) {
            System.out.println("密码错误");
        } else {
            System.out.println("未知错误");
        }
    }

    public static void register(Socket socket) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println("===注册===");
        System.out.println("请输入用户名：");
        String name = scanner.next();

        System.out.println("请输入密码：");
        String password = scanner.next();

        wirteMessage2Client(bufferedWriter, "register");

        StringBuilder sb = new StringBuilder();
        sb.append("username=").append(name).append("&password=").append(password);
        wirteMessage2Client(bufferedWriter, sb.toString());

        String message = bufferedReader.readLine();
        System.out.println("服务端回复：" + message);

        if (message.equals("1")) {
            System.out.println("注册成功, 返回登录");
        } else if (message.equals("2")) {
            System.out.println("用户名不合法：6~18位字母");
        } else if (message.equals("3")) {
            System.out.println("用户已存在");
        } else if (message.equals("4")) {
            System.out.println("密码格式错误！第一位必须是字母，后面必须是数字");
        } else {
            System.out.println("未知错误");
        }
    }

    public static void talk2All(BufferedWriter bufferedWriter) throws IOException {
        while (true) {
            System.out.println("请输入要发送的消息1：");
            String str = scanner.nextLine();

           str = scanner.nextLine();
            wirteMessage2Client(bufferedWriter, str);
        }
    }

    public static void wirteMessage2Client(BufferedWriter bufferedWriter, String message) throws IOException {
        bufferedWriter.write(message);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

}
