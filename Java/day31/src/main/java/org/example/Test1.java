package org.example;

public class Test1 {
    public static void main(String[] args) {
        Runnable task1 = new SellTicket("窗口1");
        Runnable task2 = new SellTicket("窗口2");
        Runnable task3 = new SellTicket("窗口3");

        new Thread(task1).start();
        new Thread(task2).start();
        new Thread(task3).start();
    }
}