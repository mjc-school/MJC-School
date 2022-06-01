package com.epam.mjc.inspections;

public class Demo_01 {

    public static void main(String[] args) {
        String firstString = getFirstString();
        String secondString = getSecondString();

        System.out.println(firstString == secondString);
    }

    private static String getSecondString() {
        return "Hello";
    }

    private static String getFirstString() {
        return "world";
    }
}
