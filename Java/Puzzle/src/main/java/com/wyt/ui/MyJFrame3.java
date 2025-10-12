package com.wyt.ui;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame3 extends JFrame implements KeyListener {
    public MyJFrame3() {
        this.setSize(603, 680);
        this.setLocationRelativeTo(null);  // 居中
        this.setAlwaysOnTop(true);         // 置顶
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("拼图游戏 - 键盘监听");

        // 添加键盘监听
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();

        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("键盘输入: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下: " + e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("释放: " + e.getKeyCode());
    }

    public static void main(String[] args) {
        new MyJFrame3();
    }
}
