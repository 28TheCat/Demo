package org.example.day2;

public class MyRunnable implements Runnable {

    private String taskName;

    public MyRunnable(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 正在执行任务: " + taskName);
        try {
            Thread.sleep(1000); // 模拟任务耗时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}