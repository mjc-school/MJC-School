package com.epam.training.weapons.model;

import java.util.Objects;

public abstract class AbstractWeapon {
    private String name;
    private int weight; // in gramme


    public AbstractWeapon(String name,int weight) {
        this.name = name;
        this.weight = weight;
    }


    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractWeapon that = (AbstractWeapon) o;
        return weight == that.weight &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }
}
