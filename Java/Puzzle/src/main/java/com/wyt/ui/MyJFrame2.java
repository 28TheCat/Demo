package com.wyt.ui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame2 extends JFrame implements MouseListener {

    JButton jtb = new JButton("点我");

    public MyJFrame2() {
        this.setSize(603, 680);
        this.setLocationRelativeTo(null);  // 居中
        this.setAlwaysOnTop(true);         // 置顶
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("拼图游戏 ");
        this.setLayout(null);

        jtb.setBounds(0, 0, 100, 50);
        jtb.addMouseListener(this); // ✅ 给按钮添加鼠标监听
        this.getContentPane().add(jtb);

        this.setVisible(true);
    }

    // ========== MouseListener 必须实现的 5 个方法 ==========
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("鼠标点击了按钮！");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("鼠标按下");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("鼠标释放");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("鼠标移入按钮区域");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("鼠标移出按钮区域");
    }

    public static void main(String[] args) {
        new MyJFrame2();
    }
}
