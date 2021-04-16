package com.epam.training.weapons.model;

import java.util.Objects;

public class Blade extends AbstractWeapon{
    public enum HandCount{
        ONE_HAND,
        TWO_HAND;
    }
    private int length;
    private HandCount handCount;


    public Blade(String name,int weight,int length, HandCount handCount) {
        super(name,weight);
        this.length = length;
        this.handCount = handCount;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public HandCount getHandCount() {
        return handCount;
    }

    public void setHandCount(HandCount handCount) {
        this.handCount = handCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Blade blade = (Blade) o;
        return length == blade.length &&
                handCount == blade.handCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), length, handCount);
    }
}
