package com.wyt.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    // 游戏数据（4x4矩阵，表示拼图块编号）
    private int[][] data = new int[4][4];
    // 空白块坐标
    private int emptyX = 3;
    private int emptyY = 3;
    // 当前拼图路径（一个文件夹路径）
    private String path = "src/image/animal/animal1/";
    private int step = 0;
    int [][] win={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
    JMenuItem replayItem = new JMenuItem("重新开始");
    JMenuItem changePicture = new JMenuItem("更换图片");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem exitItem = new JMenuItem("关闭游戏");
    JMenuItem accountItem= new JMenuItem("公众号");
    public GameJFrame() {
        initJFrame();
        initMenu();
        initData();
        initImage();
        this.setVisible(true);
    }

    // 随机选择一个拼图文件夹
    private String roundImage() {
        String basePath = "src/image/";
        String[] str = {
                "animal/animal1/", "animal/animal2/", "animal/animal3/", "animal/animal4/",
                "animal/animal5/", "animal/animal6/", "animal/animal7/", "animal/animal8/",
                "girl/girl1/", "girl/girl2/", "girl/girl3/", "girl/girl4/",
                "girl/girl5/", "girl/girl6/", "girl/girl7/", "girl/girl8/", "girl/girl9/"
        };

        int index = (int) (Math.random() * str.length);
        return basePath + str[index];
    }

    // 判断是否胜利
    private boolean  victory() {
     

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (data[i][j] != win[i][j]) {
                    return false; // 有一块不对
                }
            }
        }
        System.out.println("恭喜你，拼图成功！");
        return true; // 全部一致
    }


    // 更换拼图
    private void changeImage() {
        String newPath;
        do {
            newPath = roundImage(); // 随机生成新路径
        } while (newPath.equals(this.path)); // 保证和当前不一样

        this.path = newPath; // 更新路径
        initImage(); // 重新加载拼图
    }

    // 初始化窗口
    private void initJFrame() {
        this.setTitle("拼图游戏");
        this.setSize(603, 680);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setLayout(null);
        this.addKeyListener(this);
    }

    // 初始化菜单
    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu functionMenu = new JMenu("功能");
        menuBar.add(functionMenu);

    
        functionMenu.add(replayItem);
        replayItem.addActionListener(this);
        functionMenu.add(changePicture);
        functionMenu.add(reLoginItem);
        functionMenu.add(exitItem);

        JMenu aboutMenu = new JMenu("关于我们");
        menuBar.add(aboutMenu);

        aboutMenu.add(accountItem);

        // 菜单事件绑定
        replayItem.addActionListener(e -> initImage());
        changePicture.addActionListener(e -> changeImage());
        exitItem.addActionListener(e -> System.exit(0));

        this.setJMenuBar(menuBar);
    }

    // 初始化拼图
    private void initData() {
        this.getContentPane().removeAll(); // 清空旧画面


        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,0};
        // Fisher–Yates 洗牌算法
        for (int i = a.length - 1; i > 0; i--) {
            int b = (int) (Math.random() * (i + 1));
            int temp = a[i];
            a[i] = a[b];
            a[b] = temp;
        }

        // 转成二维数组
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                data[i][j] = a[i * 4 + j];
                if (data[i][j] ==16) { // 记录空白位置
                    emptyX = i;
                    emptyY = j;
                }
            }
        }
    }

    // 显示完整拼图
    private void printAllImage() {
        this.getContentPane().removeAll();
        if( victory()){
            JLabel win = new JLabel(new ImageIcon("src/image/win.png"));

            win.setBounds(203, 283, 197, 73);
            this.getContentPane().add(win);

        }
        JLabel stepLabel = new JLabel("步数：" + step);
        stepLabel.setBounds(50, 30, 130, 20);
        JLabel jLabel = new JLabel(new ImageIcon(path + "all.jpg"));
        jLabel.setBounds(83, 134, 420, 420);
        jLabel.setBorder(new BevelBorder(0));
        this.getContentPane().add(jLabel);

        JLabel background = new JLabel(new ImageIcon("src/image/background.png"));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);

        this.getContentPane().repaint();
    }

    // 绘制拼图小块
    private void initImage() {
        this.getContentPane().removeAll();
        if( victory()){
            JLabel win = new JLabel(new ImageIcon("src/image/win.png"));
            win.setBounds(203, 283, 197, 73);
            this.getContentPane().add(win);
        }
        JLabel stepLabel = new JLabel("步数：" + step);
        stepLabel.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepLabel);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int index = data[i][j];
                if (index == 16) {
                    continue; // 空白不画
                }
                JLabel jLabel = new JLabel(
                        new ImageIcon(path + (index) + ".jpg")
                );
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                jLabel.setBorder(new BevelBorder(0));
                this.getContentPane().add(jLabel);
            }
        }

        JLabel background = new JLabel(new ImageIcon("src/image/background.png"));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);

        this.getContentPane().repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if( victory()) return;
    // 方向键逻辑
    if (code == KeyEvent.VK_LEFT) { // ←
     
        if (emptyY < 3) {
            data[emptyX][emptyY] = data[emptyX][emptyY + 1];
            data[emptyX][emptyY + 1] = 16;
            emptyY++;
            initImage();
            step++;
        }
    } else if (code == KeyEvent.VK_RIGHT) { // →
  
        if (emptyY > 0) {
            data[emptyX][emptyY] = data[emptyX][emptyY - 1];
            data[emptyX][emptyY - 1] = 16;
            emptyY--;
            initImage();
            step++;
        }
    } else if (code == KeyEvent.VK_UP) { // ↑
      
        if (emptyX < 3) {
            data[emptyX][emptyY] = data[emptyX + 1][emptyY];
            data[emptyX + 1][emptyY] = 16;
            emptyX++;
            initImage();
            step++;
        }
    } else if (code == KeyEvent.VK_DOWN) { // ↓

        if (emptyX > 0) {
            data[emptyX][emptyY] = data[emptyX - 1][emptyY];
            data[emptyX - 1][emptyY] = 16;
            emptyX--;
            initImage();      
            step++;
        }
    }

    // A 键按下 → 显示完整拼图
    else if (code == KeyEvent.VK_A) {
        printAllImage();
    }
    // W 键 → 作弊码
    else if (code == KeyEvent.VK_W) {
        data = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}
        };
        initImage();
        System.out.println(step);
    }
    // R 键 → 重新开始
    else if(code==KeyEvent.VK_R){
        initImage();
    }
}

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        // A 键松开 → 恢复拼图
        if (code == KeyEvent.VK_A) {
            initImage();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // 不需要逻辑
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
    Object obj=e.getSource();
    if(obj==replayItem){
        step=0;
        initData();
        initImage();
    }
    else if(obj==reLoginItem){
        this.setVisible(false);
        new LoginJframe();
    }
    else if(obj==changePicture){
        changeImage();
    }
    else if(obj==exitItem){
        System.exit(0);
    }
    else if(obj==accountItem){
       JDialog jDialog=new JDialog();
       JLabel jLabel=new JLabel(new ImageIcon("src/image/about.png"));

        jLabel.setBounds(0,0,258,258);
        jDialog.getContentPane().add(jLabel);
        jDialog.setSize(344,344);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setModal(true);
      jDialog.setVisible(true);
    }
    }
}
