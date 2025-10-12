package com.wyt;

public class demo11 {
    public static void main(String[] args) {
        usePrinter(s->System.out.println(s.toUpperCase()));
        PrintString ps=new PrintString();
        usePrinter(ps::printUpper);
    }
    private static void usePrinter(Printer printer){
        printer.printUpperCase("hello world");
    }


}
