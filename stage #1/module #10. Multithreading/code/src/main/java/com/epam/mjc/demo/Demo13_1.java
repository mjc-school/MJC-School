package com.epam.mjc.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Demo13_1 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream().parallel().forEach(new MyConsumer());
    }
}

class MyConsumer implements Consumer<Integer> {

    @Override
    public void accept(Integer integer) {
        System.out.println("Doing some work with " + integer + " in thread " + Thread.currentThread().getName());
    }
}
