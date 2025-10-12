package org.example.day2;

public class SentGift implements Runnable{
    public static int count = 100;
    private final Object lock = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (count <= 10) {
                    break;
                }
                count--;
            }
            System.out.println("送了一份礼物"+ Thread.currentThread().getName()+"还有"+count+"个礼物");
        }
    }
}
