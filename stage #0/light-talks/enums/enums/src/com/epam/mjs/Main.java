package com.epam.mjs;

public class Main {

    public static void main(String[] args) {
        System.out.println(Unit.class);
        System.out.println(Unit.KILOMETER.getClass() + " " + Unit.KILOMETER.getClass().getSuperclass());
        System.out.println(Unit.METER.getClass() + " " + Unit.METER.getClass().getSuperclass());
        System.out.println(Unit.MILLIMETER.getClass() + " " + Unit.MILLIMETER.getClass().getSuperclass());

    }
}
