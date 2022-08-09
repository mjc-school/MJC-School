package com.epam.mjs;

enum Unit {
    KILOMETER { public double getLength() { return 1000; }
    },
    METER { public double getLength() { return 1; }
    },
    MILLIMETER { public double getLength() { return 0.001; }
    };
    public abstract double getLength();
}

