package com.wyt;

public class Test9 {
    //try 1
//    public static void main(String[] args) {
//         System.out.println(generateVerificationCode());
//    }
//    static char randomChar() {
//        int a=(int)(Math.random() * 2);
//        if(a>=1)
//            return (char)((int)(Math.random() * 26)+ 'A');
//        else
//        return (char)((int)(Math.random() * 26)+ 'a');
//    }
//    static char randomInt(){
//        return (char)((int)(Math.random() * 10)+ '0');
//    }
//    static String generateVerificationCode() {
//        String code="";
//        for (int i = 0; i < 5; i++){
//           if(i==4){
//               code+= randomInt();
//           }
//           else {
//               code+=randomChar();
//           }
//        }
//        return code;
//    }
    //try 2
    public static void main(String[] args) {
        System.out.println(generateVerificationCode());
    }
    public static String generateVerificationCode() {
        String code="";
        int digit = (int)(Math.random()*5);
        for (int i = 0; i < 5; i++){
            if(i==digit){
                code+=(int) (Math.random()*10);
            }
            else {
                code+=Random((int)(Math.random()*36));
            }
        }
        return code;
    }
    public static char Random(int n) {
        char[] chars=new char[52];
        for (int i = 0; i < chars.length; i++) {
            if (i < 26) {
                chars[i] = (char) (i  + 'A');
            } else {
                chars[i] = (char) (i - 26 + 'a');
            }
        }
        return chars[n] ;
    }
}
