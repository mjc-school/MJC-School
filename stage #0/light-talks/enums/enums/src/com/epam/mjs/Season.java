package com.epam.mjs;

import java.io.Serializable;

public enum Season implements Serializable {
    WINTER {
        @Override
        public void print() {
            System.out.println("Winter is coming");
        }
    }, SPRING {
        @Override
        public void print() {
            System.out.println("Hooray! It's spring");
        }
    }, SUMMER {
        @Override
        public void print() {
            System.out.println("Summer is here");
        }
    }, AUTUMN {
        @Override
        public void print() {
            System.out.println("Autumn");
        }
    };

    public abstract void print();

    public void printHello() {
        System.out.println("Hello " + this);
    }

    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}