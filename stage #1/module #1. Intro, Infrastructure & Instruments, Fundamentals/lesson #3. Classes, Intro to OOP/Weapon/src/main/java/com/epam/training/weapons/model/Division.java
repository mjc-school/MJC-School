package com.epam.training.weapons.model;

import java.util.ArrayList;
import java.util.List;

public class Division {
    private String name;
    private List<AbstractWeapon> weapons;

    public Division() {
        weapons = new ArrayList<>();
        this.name = "Standart Division";
    }

    public void add (AbstractWeapon weapon){
        weapons.add(weapon);
    }

    public List<AbstractWeapon> getWeapons() {
        return weapons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
