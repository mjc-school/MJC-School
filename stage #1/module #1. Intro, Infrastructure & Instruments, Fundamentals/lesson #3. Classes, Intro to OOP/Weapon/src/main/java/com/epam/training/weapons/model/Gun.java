package com.epam.training.weapons.model;

import java.util.Objects;

public class Gun extends AbstractWeapon{

    private int capacity;
    private double calibre;


    public Gun(int capacity, double calibre, String name, int weight) {
        super(name,weight);
        this.capacity = capacity;
        this.calibre = calibre;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getCalibre() {
        return calibre;
    }

    public void setCalibre(double calibre) {
        this.calibre = calibre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Gun gun = (Gun) o;
        return capacity == gun.capacity &&
                Double.compare(gun.calibre, calibre) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity, calibre);
    }
}
