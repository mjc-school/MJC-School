package com.epam.mjc.hotkeys;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class Demo_01 {

    private void altEnter() {
        int a = 1 + 2;
    }

    private void ctrlW() {
        int a = getInt();

        if (a > 0) {
            if (a < 10) {
                System.out.println(a);
            }
        }

        System.out.println(abs(abs(abs(abs(abs(abs(a)))))));
    }

    private void ctrlC_ctrlV_ctrlX_ctrlY_ctrlD_ctrlShiftV() {
        System.out.println("I'm a line of text");
    }

    private void shiftF6() {
        SomeClass someClass = new SomeClass();

        someClass.method();
    }

    private void ctrlSlash() {
        System.out.println("Comment me");
        System.out.println("And me");
    }

    private void ctrlF_ctrlR_ctrlShiftF_ctrlShiftR() {
        System.out.println("Rare text");
        System.out.println("1234-1234"); // for regex
    }

    private void ctrlAltM_ctrlAltP_ctrlAltC() {
        double a = getDouble() * 2;

        double b = a > 0 ? Math.cos(a) : Math.sin(-a);
        double c = b > 0 ? Math.cos(b) : Math.sin(-b);

        System.out.println(c);
    }

    private void ctrlAltV() {
        System.out.println(sin(cos(abs(getDouble()))));
    }

    private void ctrlB_altF7() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");

        System.out.println(list);
    }

    private void altInsert() {
        class MyBean {
            int age;
            String name;
        }
    }

    private void ctrlAltL() {
        if (getInt() > 0)
        {
        if (getDouble() > 0) {
                    System.out.println("Both greater than 0");
        }
        }
    }

    //

    private class SomeClass {
        boolean method() {
            return true;
        }
    }

    private int getInt() {
        return 2;
    }

    private double getDouble() {
        return 2;
    }

}
