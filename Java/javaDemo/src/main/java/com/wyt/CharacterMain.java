package com.wyt;

public class CharacterMain {
    public static void main(String[] args) {
        System.out.println("======= 开始角色对战 =======");

        // 创建两个对战角色
        CharacterQF qf = new CharacterQF("清风侠客", 200, 20, "风之剑", 80, "风卷残云");
        CharacterJZM jzm = new CharacterJZM("金钟门主", 250, 18, "金刚拳", 12);

        // 展示初始状态
        System.out.println("\n----- 初始状态 -----");
        qf.show();
        jzm.show();

        // 战斗回合
        System.out.println("\n======= 战斗开始 =======");

        // 第一回合
        System.out.println("\n----- 第一回合 -----");
        qf.attack(jzm);      // 清风侠客攻击
        jzm.attack(qf);      // 金钟门主攻击

        // 第二回合
        System.out.println("\n----- 第二回合 -----");
        qf.useSpecialSkill(jzm);  // 清风侠客使用特殊技能
        jzm.defend();              // 金钟门主防御

        // 第三回合
        System.out.println("\n----- 第三回合 -----");
        qf.attack(jzm);      // 清风侠客攻击
        jzm.ultimateSkill(qf);    // 金钟门主释放必杀技

        // 第四回合
        System.out.println("\n----- 第四回合 -----");
        qf.useSpecialSkill(jzm);  // 清风侠客使用特殊技能
        jzm.attack(qf);      // 金钟门主攻击

        // 战斗结束，显示最终状态
        System.out.println("\n======= 战斗结束 =======");
        System.out.println("\n----- 最终状态 -----");
        qf.show();
        jzm.show();

        // 判定胜负
        System.out.println("\n----- 战斗结果 -----");
        if (qf.getHP() <= 0 && jzm.getHP() <= 0) {
            System.out.println("双方同归于尽！");
        } else if (qf.getHP() <= 0) {
            System.out.println(jzm.getName() + "获得胜利！");
        } else if (jzm.getHP() <= 0) {
            System.out.println(qf.getName() + "获得胜利！");
        } else {
            System.out.println("战斗暂停，双方都还存活！");
        }
    }
}
