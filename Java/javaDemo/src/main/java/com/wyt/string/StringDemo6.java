package com.wyt.string;
import java.util.Scanner;

public class StringDemo6 {
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print ("请输入要转换的整数（0-99999）：");
        int num = sc.nextInt ();

        String bigNum = getBig (num);
        System.out.println ("中文大写：" + bigNum);

        sc.close();
    }

    /**

     将整数转换为中文大写形式（支持 0-99999 范围）
     @param n 要转换的整数
     @return 中文大写字符串
     */
    static String getBig (int n) {
        char [] numChars = {'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
        char [] unitChars = {'拾', '佰', '仟', '万'};
        if (n == 0) {
            return "零";
        }
        StringBuilder result = new StringBuilder ();
        int unitIndex = 0;
        while (n> 0) {
            int digit = n % 10;
            if (digit != 0) {
                result.insert (0, numChars [digit] + (unitIndex > 0 ? String.valueOf (unitChars [unitIndex - 1]) : ""));
            } else {
                if (result.length () > 0 && result.charAt (0) != '零') {
                    result.insert (0, numChars [digit]);
                }
            }
            n = n / 10;
            unitIndex++;
        }
        if (result.length () >= 2 && result.charAt (0) == '壹' && result.charAt (1) == '拾') {
            result.deleteCharAt (0);
        }
        return result.toString();
    }
}