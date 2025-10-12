package com.wyt.ui;

import javax.swing.*;
import java.awt.event.*;

public class RegisterJFrame extends JFrame implements MouseListener {
    private User user = new User();
    JButton register = new JButton("注册");
    JButton reset = new JButton("重置");
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JPasswordField rePassword = new JPasswordField();

    public RegisterJFrame() {
        initJFrame();
        this.setVisible(true);
    }

    public void initJFrame() {
        this.setSize(488, 430);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("拼图游戏  注册");
        this.setLayout(null);

        // 用户名文字
        JLabel usernameText = new JLabel(new ImageIcon("src/image/register/注册用户名.png"));
        usernameText.setBounds(106, 135, 80, 17);
        this.getContentPane().add(usernameText);

        // 用户名输入框
        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        // 密码文字
        JLabel passwordText = new JLabel(new ImageIcon("src/image/register/注册密码.png"));
        passwordText.setBounds(110, 200, 72, 16);
        this.getContentPane().add(passwordText);

        // 密码输入框
        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        // 确认密码文字
        JLabel rePasswordText = new JLabel(new ImageIcon("src/image/register/再次输入密码.png"));
        rePasswordText.setBounds(96, 256, 100, 30);
        this.getContentPane().add(rePasswordText);

        // 确认密码输入框
        rePassword.setBounds(195, 256, 200, 30);
        this.getContentPane().add(rePassword);

        // 注册按钮
        register.setBounds(123, 310, 128, 47);
        register.setIcon(new ImageIcon("src/image/register/注册按钮.png"));
        register.setBorderPainted(false);        // 去掉边框
        register.setContentAreaFilled(false);    // 去掉背景
        this.getContentPane().add(register);
        register.addMouseListener(this); // 给按钮绑定鼠标事件

       reset.setBounds(256, 310, 128, 47);
        reset.setIcon(new ImageIcon("src/image/register/重置按钮.png"));
        reset.setBorderPainted(false);        // 去掉边框
        reset.setContentAreaFilled(false);    // 去掉背景
        this.getContentPane().add(reset);
        reset.addMouseListener(this); // 给按钮绑定鼠标事件
        // 添加背景图片

        JLabel background = new JLabel(new ImageIcon("src/image/register/background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);
    }


    public void showJDialog(String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置大小
        jDialog.setSize(200, 150);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);

        //创建Jlabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);

        //让弹框展示出来
        jDialog.setVisible(true);
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
    // ================== 鼠标事件方法 ==================
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == register) {
            System.out.println("鼠标点击注册");
            String usernameInput = username.getText();
            String passwordInput = new String(password.getPassword());
            String rePasswordInput = new String(rePassword.getPassword());
            User userInput = new User(usernameInput, passwordInput);

            if (usernameInput.isEmpty() || passwordInput.isEmpty()) {
                showJDialog("用户名或密码不能为空");
            }
            else if (!passwordInput.equals(rePasswordInput)) {
                showJDialog("密码不一致");
            }
            else if (contains(userInput)) {
                showJDialog("用户已存在");
            }
            else {
                // 注册成功
                User.users.add(userInput); // 将新用户加入静态集合
                showJDialog("注册成功");
                this.setVisible(false);
                new LoginJframe();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == register) {
            register.setIcon(new ImageIcon("src/image/register/注册按下.png"));
        }
        else if (e.getSource() == reset) {
            reset.setIcon(new ImageIcon("src/image/register/重置按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == register) {
            register.setIcon(new ImageIcon("src/image/register/注册按钮.png"));
        }
        else if (e.getSource() == reset) {
            reset.setIcon(new ImageIcon("src/image/register/重置按钮.png"));
        }
    }


    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
