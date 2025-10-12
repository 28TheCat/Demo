package org.example;

import java.util.concurrent.Callable;


public class MyCallable implements Callable<String> {

    private String name;
    private int tic;

    public MyCallable(String name) {
        this.name = name;
    }

    public MyCallable() {
    }
    @Override
    public String call() throws Exception {
        String s= "";
        for(int i=0;i<this.tic;i++){
            s = Thread.currentThread().getName()+"正在卖第"+i+"张票";
        }
        return s;
    }
}

