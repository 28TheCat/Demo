package com.wyt.arryList;

import java.util.ArrayList;

public class User {
    private String name;
    private int id;
    private String password;
    public User(String name, int id, String password){
        this.name = name;
        this.id = id;
        this.password = password;
    }
    public User(){}

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void showUser() {
        System.out.println("用户名：" + this.name + "，用户id：" + this.id + "，用户密码：" + this.password);
    }
    public boolean find(int id){
        if(id == this.id){
            return true;
        }
        return false;
    }
    public static void main(String[] args)
    {
        ArrayList<User> users = new ArrayList<User>();
        User user1 = new User("张三", 1, "123456");
        User user2 = new User("李四", 2, "123456");
        User user3 = new User("王五", 3, "123456");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        System.out.printf("请输入你想要找到用户的id:");
        int id = new java.util.Scanner(System.in).nextInt();
        showUsers(users, id);
    }
    public static void showUsers(ArrayList<User> users, int id){
        for(int i=0; i<users.size(); i++){
            if(users.get(i).find(id)){
                System.out.println("找到该用户");
                users.get(i).showUser();
            }
        }
        System.out.println("该用户不存在");
    }
}
