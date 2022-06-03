package com.epam.mjc.inspections;

import java.util.Scanner;

public class Demo_03 {

    public static void main(String[] args) {
        System.out.println(doComputations(getBool()));
    }

    private static boolean getBool() {
        return true;
    }

    private static boolean doComputations(boolean bool) {
        if (bool == false) {
            return true;
        } else {
            return false;
        }
    }
}
