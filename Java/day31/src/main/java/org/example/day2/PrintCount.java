package org.example.day2;

public class PrintCount implements Runnable {
    public static int count = 100;
    private final Object lock = new Object();
    public   PrintCount (){}

    @Override
    public void run() {
        while ( true){
            synchronized (lock){
                if (count <= 0){
                    break;
                }
                count--;
            }
            System.out.println(Thread.currentThread().getName()+"打印了 "+count);
        }



    }
}
