package com.wyt;

public class Employee implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private  String name;
    private  String adress;
    private  transient int age;
    public Employee(String name, String adress, int age) {
        this.name = name;
        this.adress = adress;
        this.age = age;
    }
    public Employee() {
    }
    public void addressCheck(){
        System.out.println("Address check:"+name+"----"+adress);
    }

    @Override
    public String toString() {
        return "name:" + name + "  adress:" + adress + "  age:" + age;
    }
}
