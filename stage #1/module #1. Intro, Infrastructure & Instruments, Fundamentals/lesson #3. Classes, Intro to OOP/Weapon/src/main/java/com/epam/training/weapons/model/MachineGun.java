package com.epam.training.weapons.model;

import java.util.Objects;

public class MachineGun extends Gun{

    private int rapidity;

    public MachineGun(int capacity,double calibre,int weight, String name, int rapidity) {
        super(capacity,calibre, name,weight);
        this.rapidity = rapidity;
    }

    public int getRapidity() {
        return rapidity;
    }

    public void setRapidity(int rapidity) {
        this.rapidity = rapidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MachineGun that = (MachineGun) o;
        return rapidity == that.rapidity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rapidity);
    }
}
