package com.wyt;

public class GirlFriendTest {
    public static void main(String[] args) {
        GirlFriend gf1 = new GirlFriend("小花", 18, 1.56);
        GirlFriend gf2 = new GirlFriend("小明", 18, 1.66);

        gf1.show();
        gf2.show();
        gf1.dateWithGirlFriend();
        gf1.kiss();
    }
}
