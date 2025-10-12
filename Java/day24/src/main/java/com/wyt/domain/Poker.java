package com.wyt.domain;

import javax.sql.PooledConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class Poker extends JLabel implements MouseListener {
    private String name;
    private boolean up;
    private boolean canClick=false;
    private boolean clicked=false;

    public Poker(String name,boolean up){
        this.name=name;
        this.up=up;
        if(this.up){
            this.turnFront();
        }
        else {
            this.turnRear();
        }
        this.setSize(71,96);
        this.setVisible(true);
        this.addMouseListener(this);

    }
    public void turnFront(){
        this.setIcon(new ImageIcon("src/img/poker/"+name+".png"));
        this.up=true;
    }
    public void turnRear(){
        this.setIcon(new ImageIcon("src/img/poker/rear.png"));
        this.up=false;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.canClick){
            Point from=this.getLocation();
            int step;
            if(clicked)step=-20;
            else step=20;
            this.clicked=!clicked;
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isUp() {
        return up;
    }
    public void setUp(boolean up) {
        this.up = up;
    }
    public void setCanClick(boolean canClick) {
        this.canClick = canClick;
    }
    public boolean isClicked() {
        return clicked;
    }
    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

}
