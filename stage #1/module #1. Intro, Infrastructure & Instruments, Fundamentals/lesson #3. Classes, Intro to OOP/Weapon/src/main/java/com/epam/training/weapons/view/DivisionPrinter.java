package com.epam.training.weapons.view;

import com.epam.training.weapons.logic.DivisionLogic;
import com.epam.training.weapons.model.Division;

public class DivisionPrinter {

    public void print(Division division){
        int weaponQuantity = division.getWeapons().size();
        String name = division.getName();
        double weaponWeight = DivisionLogic.calculateTotalWeight(division);
        System.out.println("Division name: " + name
                + "\nWeapon weight: " + weaponWeight
                + "\nWeapon quantity: " + weaponQuantity);


    }

}
