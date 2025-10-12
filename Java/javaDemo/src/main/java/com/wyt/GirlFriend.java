package com.wyt;

public class GirlFriend {
    private String name;
    private int age;
    private double height;

    public GirlFriend(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
    public void show() {
        System.out.println("姓名：" + name + "，年龄：" + age + "，身高：" + height);
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getHeight() {
        return height;
    }

    public void dateWithGirlFriend(){
        System.out.println("正在和"+name+"约会......");
    }
    public void kiss(){
        System.out.printf("正在和"+name+"亲亲......\n");
    }
}
