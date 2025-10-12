package com.wyt;

public class demo5 {
    public static void main(String[] args) {
        String a="^[a-zA-Z0-9-._]{2,20}@[A-Za-z0-9]{2,6}.[A-Za-z]{2,6}$";
        String gmail="w2607674311@gmail.com";
        System.out.println(gmail.matches(a));
    }
}
