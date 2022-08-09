package com.epam.mjs;

public enum CurrencyEnum {

    PENNY(1), NICKLE (5), DIME(10), QUARTER(25);

    private int value;

    CurrencyEnum(int value) {
        this.value = value;
    }
}
