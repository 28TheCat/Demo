package com.wyt;

public class Character {
    private String name;
    private int HP;
    private int attack;
    private String skill; // 已声明但未初始化和提供访问方法

    // 带参数的构造方法，补充skill初始化
    public Character(String name, int HP, int attack, String skill) {
        this.name = name;
        this.HP = HP;
        this.attack = attack;
        this.skill = skill; // 初始化技能
    }

    // 默认构造方法，补充skill默认值
    public Character() {
        this.name = "默认角色";
        this.HP = 100;
        this.attack = 10;
        this.skill = "普通攻击"; // 默认技能
    }

    // getter和setter方法（补充skill的访问方法）
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    // 展示角色信息
    public void show() {
        System.out.println("角色名：" + name + "  HP：" + HP + "  攻击力：" + attack + "  技能：" + skill);
    }

    // 技能展示方法
    public void skill() {
        System.out.println(this.getName() + "使用了技能: " + this.skill);
    }
    public void dead() {
        if (this.HP == 0) {
            System.out.println(this.name + "已经倒下了！");
        }
    }
    public void attack(Character enemy) {
        System.out.println(this.getName() + "使用了技能: " + this.skill + " 攻击了" + enemy.getName());
        int damage = this.attack;
        System.out.println("造成了" + damage + "点伤害");
        enemy.setHP(enemy.getHP() - damage);
        if (enemy.getHP() < 0) {
            enemy.setHP(0);
            enemy.dead();
            System.out.println(this.getName() + "已胜利");
        }
        System.out.println(enemy.getName() + "剩余HP：" + enemy.getHP());
    }
}
