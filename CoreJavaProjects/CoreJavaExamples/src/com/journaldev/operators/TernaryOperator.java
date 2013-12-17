package com.journaldev.operators;

public class TernaryOperator {

    public static void main(String[] args) {
        
        System.out.println(getMinValue(4,10));
        
        System.out.println(getAbsoluteValue(-10));
        
        System.out.println(invertBoolean(true));
        
        String str = "Australia";
        String data = str.contains("A") ? "Str contains 'A'" : "Str doesn't contains 'A'";
        System.out.println(data);
    }

    private static boolean invertBoolean(boolean b) {
        return b ? false:true;
    }

    private static int getAbsoluteValue(int i) {
        return i<0 ? -i:i;
    }

    private static int getMinValue(int i, int j) {
        return (i<j) ? i : j;
    }

}
