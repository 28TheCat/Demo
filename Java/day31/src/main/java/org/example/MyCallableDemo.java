package org.example;

public class MyCallableDemo {
    public static void main(String[] args) throws Exception {
        MyCallable c = new MyCallable();
        MyCallable c1 = new MyCallable();
        System.out.println( c.call());
        System.out.println( c1.call());
    }
}
