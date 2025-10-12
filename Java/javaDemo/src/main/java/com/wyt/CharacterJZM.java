package com.wyt;

public class CharacterJZM extends Character {
    // JZM角色特有的属性
    private int defense; // 防御力
    private int rage; // 怒气值，用于释放必杀技
    private boolean isDefending; // 是否处于防御状态

    // 默认构造方法
    public CharacterJZM() {
        super("金钟门主", 250, 15, "金刚拳");
        this.defense = 10;
        this.rage = 0;
        this.isDefending = false;
    }

    // 带参数的构造方法
    public CharacterJZM(String name, int HP, int attack, String skill, int defense) {
        super(name, HP, attack, skill);
        this.defense = defense;
        this.rage = 0;
        this.isDefending = false;
    }

    // 防御技能：减少受到的伤害
    public void defend() {
        this.isDefending = true;
        System.out.println(getName() + "进入防御状态，受到的伤害将减少！");
        // 每次防御增加怒气值
        rage += 10;
        if (rage > 100) rage = 100;
    }

    // 必杀技：消耗所有怒气值，造成巨大伤害
    public void ultimateSkill(Character enemy) {
        if (rage >= 50) {
            // 怒气值越高，伤害越高
            int damage = getAttack() + (rage / 2);
            System.out.println(getName() + "释放了必杀技：金钟破！");
            System.out.println(getName() + "消耗了" + rage + "点怒气值，对" + enemy.getName() + "发动了猛烈攻击！");
            System.out.println("造成了" + damage + "点伤害");

            enemy.setHP(enemy.getHP() - damage);
            if (enemy.getHP() < 0) {
                enemy.setHP(0);
            }

            System.out.println(enemy.getName() + "剩余HP：" + enemy.getHP());
            this.rage = 0; // 重置怒气值
        } else {
            System.out.println(getName() + "怒气值不足（当前：" + rage + "），无法释放必杀技！");
        }
    }

    // 重写父类的attack方法，增加怒气值积累
    @Override
    public void attack(Character enemy) {
        super.attack(enemy);
        // 攻击后增加怒气值
        rage += 15;
        if (rage > 100) rage = 100;
        System.out.println(getName() + "的怒气值增加到：" + rage);
    }

    // 重写父类的setHP方法，考虑防御状态
    @Override
    public void setHP(int HP) {
        // 如果处于防御状态，减少受到的伤害
        if (isDefending) {
            int actualHP = this.getHP() - (this.getHP() - HP) / 2; // 伤害减半
            super.setHP(actualHP);
            isDefending = false; // 一次防御只生效一次
            System.out.println(getName() + "的防御生效，减少了一半伤害！");
        } else {
            super.setHP(HP);
        }
    }

    // 重写show方法，展示特有属性
    @Override
    public void show() {
        super.show();
        System.out.println("防御力：" + defense + "  怒气值：" + rage + "%  防御状态：" + (isDefending ? "开启" : "关闭"));
    }

    // getter和setter方法
    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getRage() {
        return rage;
    }

    public boolean isDefending() {
        return isDefending;
    }
}
