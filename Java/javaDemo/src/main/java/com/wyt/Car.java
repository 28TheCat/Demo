package com.wyt;

import java.util.Scanner;

public class Car {
    private String brand;
    private String color;
    private int price;

    public Car() {}

    public Car(String brand, String color, int price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void show() {
        System.out.println("汽车品牌是：" + brand + " 颜色是：" + color + " 价格是：" + price);
    }

    public static void main(String[] args) {
        Car[] cars = new Car[3];  // 数组名更具意义
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("===== 请输入第" + (i + 1) + "台汽车信息 =====");

            cars[i] = new Car();

            System.out.print("请输入汽车品牌：");
            String brand = sc.nextLine();
            cars[i].setBrand(brand);

            System.out.print("请输入汽车颜色：");
            String color = sc.nextLine();
            cars[i].setColor(color);

            System.out.print("请输入汽车价格：");
            int price = sc.nextInt();
            sc.nextLine();

            cars[i].setPrice(price);

            System.out.print("第" + (i + 1) + "台汽车信息：");
            cars[i].show();
            System.out.println();  // 空行分隔
        }

        sc.close();  // 关闭Scanner，释放资源
    }
}
