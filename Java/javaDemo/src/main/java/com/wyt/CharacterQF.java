package com.wyt;

public class CharacterQF extends Character {
    // 可以添加QF角色特有的属性
    private int magicPower; // 魔法值
    private String specialSkill; // 特殊技能

    // 构造方法
    public CharacterQF() {
        super("清风侠客", 150, 18, "风之剑");
        this.magicPower = 100;
        this.specialSkill = "风卷残云";
    }

    public CharacterQF(String name, int HP, int attack, String skill, int magicPower, String specialSkill) {
        super(name, HP, attack, skill);
        this.magicPower = magicPower;
        this.specialSkill = specialSkill;
    }

    // 特有的技能方法
    public void useSpecialSkill(Character enemy) {
        if (magicPower >= 30) {
            int damage = getAttack() * 2; // 特殊技能造成双倍伤害
            System.out.println(getName() + "使用了特殊技能: " + specialSkill + " 攻击了" + enemy.getName());
            System.out.println("造成了" + damage + "点伤害");
            enemy.setHP(enemy.getHP() - damage);
            if (enemy.getHP() < 0) {
                enemy.setHP(0);
            }
            magicPower -= 30; // 消耗魔法值
            System.out.println(enemy.getName() + "剩余HP：" + enemy.getHP());
            System.out.println(getName() + "剩余魔法值：" + magicPower);
        } else {
            System.out.println(getName() + "魔法值不足，无法使用" + specialSkill + "！");
            // 魔法值不足时使用普通攻击
            attack(enemy);
        }
    }

    // 重写父类的attack方法，添加额外效果
    @Override
    public void attack(Character enemy) {
        // 有20%的几率触发暴击
        boolean isCritical = Math.random() < 0.2;
        int damage = getAttack();

        if (isCritical) {
            damage *= 1.5;
            System.out.println(getName() + "发动了暴击！");
        }

        System.out.println(getName() + "使用了技能: " + getSkill() + " 攻击了" + enemy.getName());
        System.out.println("造成了" + damage + "点伤害");
        enemy.setHP(enemy.getHP() - damage);
        if (enemy.getHP() < 0) {
            enemy.setHP(0);
        }
        System.out.println(enemy.getName() + "剩余HP：" + enemy.getHP());
    }

    // 重写show方法，展示更多信息
    @Override
    public void show() {
        super.show();
        System.out.println("魔法值：" + magicPower + "  特殊技能：" + specialSkill);
    }

    // getter和setter方法
    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    public String getSpecialSkill() {
        return specialSkill;
    }

    public void setSpecialSkill(String specialSkill) {
        this.specialSkill = specialSkill;
    }
}
