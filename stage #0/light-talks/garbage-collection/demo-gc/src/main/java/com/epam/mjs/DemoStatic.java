package com.epam.mjs;

import java.util.ArrayList;

public class DemoStatic {

    private static ArrayList<Integer[]> list = new ArrayList();

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(3000);
        while (true){
            Integer[] integer = new Integer[10000];
            list.add(integer);
            integer = null;
            Thread.sleep(10);
        }
    }

}
