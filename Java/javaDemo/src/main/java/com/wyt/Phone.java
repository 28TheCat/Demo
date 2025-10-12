package com.wyt;

import java.util.Scanner;

public class Phone {
    private String brand;
    private String color;
    private int price;

    public Phone() {
    }

    public Phone(String brand, String color, int price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    // getter和setter方法
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void show() {
        System.out.println("手机品牌是：" + brand + "，颜色是：" + color + "，价格是：" + price);
    }

    public static void main(String[] args) {
        Phone[] phones = new Phone[3];
        Scanner sc = new Scanner(System.in);
double sum=0;
        for (int i = 0; i < 3; i++) {
            System.out.println("\n===== 输入第" + (i + 1) + "台手机信息 =====");
            phones[i] = new Phone();

            System.out.print("请输入手机品牌：");
            String brand = sc.nextLine();
            phones[i].setBrand(brand);

            System.out.print("请输入手机颜色：");
            String color = sc.nextLine();
            phones[i].setColor(color);

            System.out.print("请输入手机价格：");
            int price = sc.nextInt();
            phones[i].setPrice(price);

            sc.nextLine();

            System.out.print("已保存的手机信息：");
            phones[i].show();
            sum+=price;
        }
        System.out.println("手机总价为："+sum);
        System.out.printf("手机平均值为%.2f",1.0*sum/phones.length);

        sc.close();
    }
}
