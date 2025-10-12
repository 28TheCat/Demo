package com.wyt.ui;

import java.util.ArrayList;

public class User {
    public static String username;
    public static String password;

    static ArrayList<User> users = new ArrayList<>();
    static {
        users.add(new User("zhangsan","123"));
        users.add(new User("lisi","1234"));
    }


    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public User(){

    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
