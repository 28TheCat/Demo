package com.wyt;

public class demo7 implements Comparable<demo7> {
    private int age;
    private String name;

    public demo7(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public demo7() {}

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "age:" + age + " name:" + name;
    }

    @Override
    public int compareTo(demo7 other) {
        return this.age - other.age;
    }

    public static void main(String[] args) {
        demo7 d7 = new demo7(18, "张三");
        demo7 d8 = new demo7(20, "李四");


        if(d7.compareTo(d8) == 0) System.out.printf(d7.getName()+"与"+d8.getName()+"相同");
        else if(d7.compareTo(d8) > 0) System.out.printf(d7.getName()+"比"+d8.getName()+"大");
        else System.out.printf(d7.getName()+"比"+d8.getName()+"小");
        demo7 d9=new demo7(18, "王五");
        demo7 d10=new demo7(20, "赵六");
        demo7 d11=new demo7(18, "孙七");
        demo7 d12=new demo7(20, "周八");
        demo7[] d7s = new demo7[]{d7,d8,d9,d10,d11,d12};
        for(demo7 dd:d7s) {
            System.out.println(dd);
            System.out.println(dd.compareTo(d7));
        }
    }
}
