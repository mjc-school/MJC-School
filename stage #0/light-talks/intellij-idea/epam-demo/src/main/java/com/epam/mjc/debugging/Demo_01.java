package com.epam.mjc.debugging;

public class Demo_01 {

    public static void main(String[] args) {
        System.out.println(new Demo_01().doComputations(-13));
    }

    private int doComputations(int input) {
        if (input > 0) {
            input *= 10;
        } else {
            input += 10;
        }

        while (input % 10 != 0) {
            input += 3;
        }

        if (input == 0) {
            input = doComputations(input);
        }

        return input;
    }
}
