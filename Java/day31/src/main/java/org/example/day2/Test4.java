package org.example.day2;

public class Test4 {
    public static void main(String[] args) {
        PrintCount pc=new PrintCount();
        Thread t1=new Thread(pc,"线程1");
        Thread t2=new Thread(pc,"线程2");
        t1.start();
        t2.start();
    }
}
