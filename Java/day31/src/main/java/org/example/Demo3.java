package org.example;

public class Demo3 {
    public static void main(String[] args) {
        Thread cooker = new Cooker();
        Thread foodie1 = new Thread(new Foodie(), "吃货1");
        Thread foodie2 = new Thread(new Foodie(), "吃货2");

        cooker.setName("厨师");
        cooker.start();
        foodie1.start();
        foodie2.start();
    }
}
