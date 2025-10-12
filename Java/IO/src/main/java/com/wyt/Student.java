package com.wyt;

public class Student implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private transient int age;
    // 添加新的属性 ,重新编译, 可以反序列化,该属性赋为默认值.
    public int eid;
    public Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    public Student()
    {

    }
    public void nameCheck(){
        System.out.printf("Name check:"+name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Student [name=" + name + ", age=" + age + "]";
    }
}
