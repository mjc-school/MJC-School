package com.epam.mjc.inspections;

import java.util.ArrayList;
import java.util.List;

public class Demo_02 {

    public static void main(String[] args) {
        collections();
        strings();
    }

    private static void collections() {
        List<String> strings = List.of("a", "b", "c", "d");

        List<String> second = new ArrayList<>();
        for (String s: strings) {
            second.add(s);
        }

        System.out.println(second);
    }

    private static void strings() {
        String s = "";
        for (int i = 0; i < 10; i++) {
            s += "Hello World";
        }
        System.out.println(s);
    }
}
