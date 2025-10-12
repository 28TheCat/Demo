package com.wyt.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJFrame extends JFrame implements ActionListener {

    JButton jtb = new JButton("注册1");
    JButton jtb2 = new JButton("注册2");

    public MyJFrame() {
        this.setSize(603, 680);
        this.setLocationRelativeTo(null);  // 居中
        this.setAlwaysOnTop(true);         // 置顶
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("拼图游戏 ");
        this.setLayout(null);

        jtb.setBounds(0, 0, 100, 50);
        jtb.addActionListener(this);

        jtb2.setBounds(100, 100, 100, 50);
        jtb2.addActionListener(this);

        this.getContentPane().add(jtb);
        this.getContentPane().add(jtb2); // ✅ 别忘了加上

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == jtb) {
            jtb.setSize(200, 200); // 点击按钮1时变大
        } else if (source == jtb2) {
            JOptionPane.showMessageDialog(this, "你点击了 注册2 按钮！");
        }
    }

}
