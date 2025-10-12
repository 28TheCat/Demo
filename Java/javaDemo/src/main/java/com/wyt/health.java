
package com.wyt;

import java.util.Scanner;

public class health {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int age = getValidInt("请输入年龄(岁)");
        int sex = getValidSex();
        double weight = getValidDouble("请输入体重（kg）");
        double height = getValidDouble("请输入身高（m）");

        double bmi = calculateBMI(weight, height);
        System.out.printf("您的BMI是: %.3f%n", bmi);
        checkHealth(bmi);
    }

    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    public static void checkHealth(double bmi) {
        if (bmi < 18.5) System.out.println("过轻");
        else if (bmi < 25) System.out.println("正常");
        else if (bmi < 28) System.out.println("过重");
        else if (bmi < 32) System.out.println("肥胖");
        else System.out.println("超级胖");
    }

    public static double Fbmi(double weight, double height, int age) {
        return 447.593 + (9.247 * weight + (3.097 * height - 4.33 * age));
    }

    public static double Mbmi(double weight, double height, int age) {
        return 88.362 + (13.397 * weight + (4.799 * height - 5.677 * age));
    }


    private static int getValidInt(String prompt) {
        int value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println(prompt);
                value = Integer.parseInt(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("输入无效，请输入一个整数。");
            }
        }
        return value;
    }

    private static double getValidDouble(String prompt) {
        double value = 0.0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println(prompt);
                value = Double.parseDouble(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("输入无效，请输入一个数字。");
            }
        }
        return value;
    }

    // 工具方法：获取合法性别输入
    private static int getValidSex() {
        int sex = 0;
        while (sex != 1 && sex != 2) {
            sex = getValidInt("请输入性别(1代表男，2代表女）");
            if (sex != 1 && sex != 2) {
                System.out.println("请输入有效的性别（1 或 2）");
            }
        }
        return sex;
    }
}