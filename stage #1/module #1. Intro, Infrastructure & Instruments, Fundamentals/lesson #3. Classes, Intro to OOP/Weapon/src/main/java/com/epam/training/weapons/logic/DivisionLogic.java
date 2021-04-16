package com.epam.training.weapons.logic;

import com.epam.training.weapons.model.AbstractWeapon;
import com.epam.training.weapons.model.Division;

import java.util.List;

public class DivisionLogic {

    private DivisionLogic() {
        //to avoid creation instance of that class
    }

    public static double calculateTotalWeight(Division division){

        List<AbstractWeapon> weaponList = division.getWeapons();
        double resultWeight = 0.0;
        for (AbstractWeapon weapon: weaponList) {
            resultWeight = resultWeight + weapon.getWeight();
        }

        return resultWeight;
    }
}
