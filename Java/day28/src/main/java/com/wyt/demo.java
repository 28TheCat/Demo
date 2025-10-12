package com.wyt;

public class demo {
    public static void main(String[] args) throws LoginException{
        try {
            login("admin", "123456");  // 调用静态方法
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
    public static void login(String username,String password) throws LoginException{
        if(username.equals("admin") && password.equals("1a23456")){
            System.out.println("登录成功");
        }else{
            throw new LoginException("用户名或密码错误1");
        }
    }
}
