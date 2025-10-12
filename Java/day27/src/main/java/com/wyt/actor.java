package com.wyt;


public class actor {
    private String name;

    public actor(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("演员: " + name);
    }
}

