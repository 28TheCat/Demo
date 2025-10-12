package org.example;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100); // 模拟耗时操作
            } catch (InterruptedException e) {
                e.printStackTrace(); // 必须捕获异常
            }
            System.out.println(Thread.currentThread().getName() + " i=" + i);
        }
    }
}
