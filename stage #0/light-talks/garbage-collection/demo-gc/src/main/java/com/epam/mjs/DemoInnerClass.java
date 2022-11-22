package com.epam.mjs;

import java.util.ArrayList;
import com.epam.mjs.OuterClass.InnerClass;

public class DemoInnerClass {

    private static ArrayList<InnerClass> innerClasses = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(3000);
        while (true) {
            InnerClass innerClass = new OuterClass().new InnerClass();
            innerClasses.add(innerClass);
            Thread.sleep(10);
        }
    }

}
