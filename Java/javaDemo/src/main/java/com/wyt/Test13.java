package com.wyt;

public class Test13 {
    public static void main(String[] args) {
//        String str=getPassword();
        String str = "1983";
        System.out.println(str);
        String str1=getPassWordPassword(str);
        System.out.println(str1);
        System.out.println(shit(str1));
    }
    static String shit(String str){
        int number = Integer.parseInt(str);
        String result = "";
        while (number>0){
            int digit = number%10;
            if(digit<5){
                digit=digit+5;
            }
            else {
                digit=digit-5;
            }
            result+=digit;
            number = number/10;
        }
        return result;
    }
    static String getPassword(){
        String arr="";
        for(int i=0;i<4;i++){
            arr+=(int)(Math.random()*9+1);
        }
        return arr;
    }
    static String getPassWordPassword(String str) {
        int number = Integer.parseInt(str);
        String newStr="";
        while (number > 0){
            int digtal=(number % 10+5)%10;
            newStr=digtal+newStr;
            number = number / 10;
        }
        return new StringBuilder(newStr).reverse().toString();
    }
}
