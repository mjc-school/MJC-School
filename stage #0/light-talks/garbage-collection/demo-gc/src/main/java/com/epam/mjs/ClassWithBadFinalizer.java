package com.epam.mjs;

public class ClassWithBadFinalizer {

    private Integer[] ints;

    public ClassWithBadFinalizer(Integer[] ints) {
        this.ints = ints;
    }

    @Override
    protected void finalize() throws Throwable {
        Thread.sleep(200);
    }
}
