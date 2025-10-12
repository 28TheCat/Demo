package com.wyt.string;

import java.util.Scanner;

public class Idcard {
    public static void main(String[] args) {
        String idcard;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入身份证号码：");
        idcard = scanner.next();

        if (idcard.length() != 18) {
            System.out.println("身份证号码输入有误！长度必须为18位");
        } else {
            if (!isValidIdcardFormat(idcard)) {
                System.out.println("身份证号码格式有误！包含非法字符");
                return;
            }

            birthday(idcard.substring(6, 14));
            sex(idcard.charAt(16));
        }
        scanner.close();
    }

    static void birthday(String birthdayStr) {
        String year = birthdayStr.substring(0, 4);
        String month = birthdayStr.substring(4, 6);
        String day = birthdayStr.substring(6, 8);
        System.out.println("出生日期：" + year + "年" + month + "月" + day + "日");
    }
    static void sex(char sexChar) {
        int sexCode = Character.getNumericValue(sexChar);
        if (sexCode % 2 == 1) {
            System.out.println("性别为：男");
        } else {
            System.out.println("性别为：女");
        }
    }

    static boolean isValidIdcardFormat(String idcard) {
        for (int i = 0; i < 17; i++) {
            if (!Character.isDigit(idcard.charAt(i))) {
                return false;
            }
        }
        char lastChar = idcard.charAt(17);
        return Character.isDigit(lastChar) || lastChar == 'X' || lastChar == 'x';
    }
}
