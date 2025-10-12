package com.wyt;

public class demo3 {
    public static void main(String[] args) {
        // 四个手机号
        String[] phones = {
                "13112345678",
                "13712345667",
                "13945679027",
                "139456790271"  // 无效：12 位
        };

        // 正则：^ 开头，1 开头，第二位 3-9，后面 9 位数字，总共 11 位，$ 结尾
        String regex = "^1[3-9]\\d{9}$";

        // 遍历输出验证结果
        for (String phone : phones) {
            if (phone.matches("1[3-9]\\d{9}")) {
                System.out.println("✅ 手机号 " + phone + " 格式正确");
            } else {
                System.out.println("❌ 手机号 " + phone + " 格式错误");
            }
        }
    }
}
