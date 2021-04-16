package com.epam.training.weapons.logic;

import com.epam.training.weapons.model.AbstractWeapon;
import com.epam.training.weapons.model.Division;
import com.epam.training.weapons.model.Gun;
import com.epam.training.weapons.model.MachineGun;
import org.junit.Test;
import static org.junit.Assert.*;

public class DivisionLogicTest {
    @Test
    public void calculateTotalWeightTest(){

        Division division = new Division();
        double totalWeight  = DivisionLogic.calculateTotalWeight(division);
        assertTrue(0.0 == totalWeight);


        AbstractWeapon weapon = new Gun(2,4.0,"testGun",500);
        division.add(weapon);

        totalWeight  = DivisionLogic.calculateTotalWeight(division);
        assertTrue(weapon.getWeight() == totalWeight);

        AbstractWeapon weaponMachineGun = new MachineGun(2,3.4,6000,"testMachineGun",600);
        division.add(weaponMachineGun);
        totalWeight  = DivisionLogic.calculateTotalWeight(division);
        assertTrue(weapon.getWeight() + weaponMachineGun.getWeight() == totalWeight);


    }

}
