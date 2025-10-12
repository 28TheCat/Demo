package com.wyt.studentManage;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String userName;
    private String password;
    private String id;
    private String phone;

    private static ArrayList<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public User() {
        initializeUsers();
    }

    public User(String userName, String password, String id, String phone) {
        this.userName = userName;
        this.password = password;
        this.id = id;
        this.phone = phone;
    }

    /**
     * 用户注册功能
     * @return 注册成功返回true，失败返回false
     */
    public boolean register() {
        System.out.println("===== 欢迎注册 =====");

        System.out.print("请输入用户名：");
        String userName = scanner.next();

        if (!userNameCheck(userName)) {
            System.out.println("用户名不符合规范！需3-15位，包含字母和数字");
            return false;
        }

        if (findUserIndex(userName) != -1) {
            System.out.println("用户名已存在！");
            return false;
        }

        System.out.print("请输入密码：");
        String password = scanner.next();
        System.out.print("请再次输入密码：");
        String confirmPassword = scanner.next();

        if (!password.equals(confirmPassword)) {
            System.out.println("两次密码不一致！注册失败");
            return false;
        }

        System.out.print("请输入身份证号：");
        String id = scanner.next();
        if (!idCheck(id)) {
            System.out.println("身份证格式错误！");
            return false;
        }

        System.out.print("请输入手机号：");
        String phone = scanner.next();
        if (!phoneCheck(phone)) {
            System.out.println("手机号格式错误！需11位数字");
            return false;
        }

        users.add(new User(userName, password, id, phone));
        System.out.println("注册成功！请登录");
        return true;
    }

    /**
     * 用户登录功能
     * @return 登录成功返回true，失败返回false
     */
    public boolean login() {
        System.out.println("===== 欢迎登录 =====");

        System.out.print("请输入用户名：");
        String userName = scanner.next();

        int userIndex = findUserIndex(userName);
        if (userIndex == -1) {
            System.out.println("用户名不存在！");
            return false;
        }

        System.out.print("请输入密码：");
        String password = scanner.next();

        String generateVerificationCode = generateVerificationCode();
        System.out.println(generateVerificationCode);
        System.out.print("请输入验证码：");
        String a = scanner.next();
        if (generateVerificationCode.equals(a)) {
            if (users.get(userIndex).password.equals(password)) {
                System.out.println("登录成功！欢迎回来，" + userName + "！");
                return true;
            } else {
                System.out.println("密码错误！");
                return false;
            }
        }
        else {
            System.out.println("验证码错误！");
            return false;
        }
    }

    /**
     * 忘记密码功能（简化版）
     * @return 重置后的密码或提示信息
     */
    public String forgetPassword() {
        System.out.println("===== 忘记密码 =====");

        System.out.print("请输入用户名：");
        String userName = scanner.next();
        int userIndex = findUserIndex(userName);
        if (userIndex == -1) {
            return "用户名不存在！";
        }

        User user = users.get(userIndex);
        System.out.print("请输入绑定的手机号：");
        String phone = scanner.next();

        if (!user.phone.equals(phone)) {
            return "手机号验证失败！";
        }

        System.out.print("请输入新密码：");
        String newPassword = scanner.next();
        user.password = newPassword;
        return "密码重置成功！新密码已生效";
    }

    /**
     * 查找用户索引
     * @param userName 用户名
     * @return 存在返回索引，不存在返回-1
     */
    private static int findUserIndex(String userName) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).userName.equals(userName)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 手机号格式校验（11位数字）
     */
    private boolean phoneCheck(String phone) {
        if (phone.length() != 11) {
            return false;
        }
        for (char c : phone.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 用户名格式校验（3-15位，包含字母和数字）
     */
    private boolean userNameCheck(String userName) {
        // 长度校验
        if (userName.length() < 3 || userName.length() > 15) {
            return false;
        }

        boolean hasLetter = false;
        boolean hasDigit = false;

        for (char c : userName.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
            if (Character.isLetter(c)) {
                hasLetter = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        // 必须同时包含字母和数字
        return hasLetter && hasDigit;
    }

    /**
     * 身份证格式简单校验
     */
    private boolean idCheck(String id) {
        // 长度必须为18位
        if (id.length() != 18) {
            return false;
        }

        // 前17位必须为数字，第18位可以是数字或X/x
        for (int i = 0; i < 17; i++) {
            if (!Character.isDigit(id.charAt(i))) {
                return false;
            }
        }

        char lastChar = id.charAt(17);
        return Character.isDigit(lastChar) || lastChar == 'X' || lastChar == 'x';
    }

    /**
     * 初始化默认用户数据
     */
    private static void initializeUsers() {
        users.add(new User("1", "a123456", "11000019850612345X", "13245678901"));
        users.add(new User("李四", "a123456", "310000199911234562", "17712378901"));
        users.add(new User("王五", "a123456", "13000019850612345X", "18998765432"));
    }

    // getter方法（按需提供）
    public String getUserName() {
        return userName;
    }

    public String getPhone() {
        return phone;
    }
    public static String generateVerificationCode() {
        String code="";
        int digit = (int)(Math.random()*5);
        for (int i = 0; i < 5; i++){
            if(i==digit){
                code+=(int) (Math.random()*10);
            }
            else {
                code+=Random((int)(Math.random()*36));
            }
        }
        return code;
    }
    public static char Random(int n) {
        char[] chars=new char[52];
        for (int i = 0; i < chars.length; i++) {
            if (i < 26) {
                chars[i] = (char) (i  + 'A');
            } else {
                chars[i] = (char) (i - 26 + 'a');
            }
        }
        return chars[n] ;
    }
}