package org.example;

public class SellTicket implements Runnable{
   static private int tickets=100;
    private String name;
    public SellTicket() {
    }
    public SellTicket(String name) {
        this.name = name;
        this.tickets=100;
    }
    @Override
    public void run() {
        while (this.tickets>0) {
            System.out.println(this.getName() + "正在卖第" + (this.tickets) + "张票");
            this.tickets--;
        }
    }

    private String getName() {
        return this.name;
    }
}
