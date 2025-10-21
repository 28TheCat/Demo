package com.wangyating;

import org.junit.Assert;
import org.wangyating.Demo01;

public class DemoTest01 {
    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        String name = demo01.say("王洋");
        Assert.assertEquals("hello 王洋", name);
    }
}
