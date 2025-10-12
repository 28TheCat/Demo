package com.wyt.ui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LoginJframe extends JFrame implements MouseListener {
    String codeStr;

    JButton login = new JButton();
    JButton register = new JButton();
    JButton eyes=new JButton();
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JTextField code=new JTextField();
    JLabel rightCode = new JLabel();

    private int status=0;
    public LoginJframe() {
        initJFrame();
        initView();
        this.setVisible( true);
    }

    public void initJFrame() {
        this.setSize(488, 430);
        this.setTitle("拼图游戏 登录");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setLayout(null);
    }
    private void passwordEyes(){
        if (status==0) {
        }

    }
    public void initView() {
        JLabel usernameText=new JLabel(new ImageIcon("src/image/login/用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);

        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);
        JLabel passwordText=new JLabel(new ImageIcon("src/image/login/密码.png"));
        passwordText.setBounds(130,195,32,16);
        this.getContentPane().add(passwordText);

        password.setBounds(195,195,200,30);
        password.setEchoChar('•'); // 默认密文模式
        this.getContentPane().add(password);

        eyes.setBounds(395, 195, 30, 30);
        eyes.setIcon(new ImageIcon("src/image/login/显示密码.png"));
        eyes.setBorderPainted(false);
        eyes.setContentAreaFilled(false);
        eyes.setFocusPainted(false);
        this.getContentPane().add(eyes);

        JLabel codeText=new JLabel(new ImageIcon("src/image/login/验证码.png"));
        codeText.setBounds(133,256,50,30);
        this.getContentPane().add(codeText);

        code.setBounds(195,256,100,30);
        this.getContentPane().add(code);

       codeStr=CodeUtil.getCode();
        rightCode.setText(codeStr);
        rightCode.addMouseListener(this);
        rightCode.setBounds(300,256,50,30);
        this.getContentPane().add(rightCode);

        login.setBounds(123,310,128,47);
        login.setIcon(new ImageIcon("src/image/login/登录按钮.png"));
        login.setBorderPainted(false);
        login.setContentAreaFilled(false);
        login.addMouseListener( this);
        this.getContentPane().add(login);

        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("src/image/login/注册按钮.png"));
        //去除按钮的边框
        register.setBorderPainted(false);
        //去除按钮的背景
        register.setContentAreaFilled(false);
        //给注册按钮绑定鼠标事件
        register.addMouseListener(this);
        this.getContentPane().add(register);


        //7.添加背景图片
        JLabel background = new JLabel(new ImageIcon("src/image/login/background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    if(e.getSource()==login){
        System.out.println("登录");
        String usernameInput=username.getText();
        String passwordInput=password.getText();
        String codeInput=code.getText();
        User userInfo=new User(usernameInput,passwordInput);
        System.out.println("用户输入的用户名为："+usernameInput);
        System.out.println("用户输入的密码为："+passwordInput);
        if(codeInput.length()==0){
            System.out.printf("验证码不能为空");
            showJdialog("验证码不能为空");
        }
        else if(usernameInput.length()==0||passwordInput.length()==0){
            System.out.printf("用户名或密码不能为空");
        }
        else if(contains(userInfo)){
            System.out.printf("登录成功");
            showJdialog("登录成功");
            this.setVisible(false);
            new GameJFrame();
        }
        else if(!codeInput.equalsIgnoreCase(rightCode.getText())){
            System.out.printf("验证码错误");
            showJdialog("验证码错误");
            codeStr = CodeUtil.getCode();
        }
        else{
            System.out.printf("用户名或密码错误");
            showJdialog("用户名或密码错误");
        }
    }
    else if(e.getSource()==register){
        System.out.println("点击了注册");
        new RegisterJFrame();
    }
    else if(e.getSource()==rightCode){
        System.out.println("点击了验证码");
        String codeStr=CodeUtil.getCode();
        rightCode.setText(codeStr);
    }else if (e.getSource() == eyes) {
        System.out.println("点击了眼睛");
        if (status == 0) {
            // 当前是密文 → 显示明文
            password.setEchoChar((char) 0); // 0 表示不屏蔽
            eyes.setIcon(new ImageIcon("src/image/login/显示密码按下.png")); // 换成“隐藏”的小眼睛
            status = 1;
        } else {
            // 当前是明文 → 显示密文
            password.setEchoChar('•'); // 圆点显示
            eyes.setIcon(new ImageIcon("src/image/login/显示密码.png")); // 换成“显示”的小眼睛
            status = 0;
        }
    }

    }
    //判断用户在集合中是否存在
    public boolean contains(User userInput){
        for (int i = 0; i < User.users.size(); i++) {
            User rightUser = User.users.get(i);
            if(userInput.getUsername().equals(rightUser.getUsername()) && userInput.getPassword().equals(rightUser.getPassword())){
                //有相同的代表存在，返回true，后面的不需要再比了
                return true;
            }
        }
        //循环结束之后还没有找到就表示不存在
        return false;
    }
    public void showJdialog(String content){
        JDialog jDialog =new JDialog();
        jDialog.setSize(200,150);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setModal(true);
        JLabel jLabel = new JLabel(content);
        jLabel.setBounds(0,0,200,150);
        jDialog.getContentPane().add(jLabel);
        jDialog.setVisible(true);

    }
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource()==login){
            login.setIcon(new ImageIcon("src/image/login/登录按下.png"));
        }
        else if (e.getSource()==register){
            register.setIcon(new ImageIcon("src/image/login/注册按下.png"));
        }
        else if(e.getSource()==eyes){
            eyes.setIcon(new ImageIcon("src/image/login/显示密码按下.png"));
        }

    }
    @Override
    public void mouseReleased(MouseEvent e) {
if (e.getSource()==login){
    login.setIcon(new ImageIcon("src/image/login/登录按钮.png"));
}
else if (e.getSource()==register){
    register.setIcon(new ImageIcon("src/image/login/注册按钮.png"));
}else if(e.getSource()==eyes){
    if (status == 0) {
        eyes.setIcon(new ImageIcon("src/image/login/显示密码.png"));
    } else {
        eyes.setIcon(new ImageIcon("src/image/login/隐藏密码.png"));
    }
}

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
