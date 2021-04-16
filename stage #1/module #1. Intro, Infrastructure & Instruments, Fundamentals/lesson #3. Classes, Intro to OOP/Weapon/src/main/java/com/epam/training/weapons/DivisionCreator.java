package com.epam.training.weapons;

import com.epam.training.weapons.model.Blade;
import com.epam.training.weapons.model.Division;
import com.epam.training.weapons.model.Gun;
import com.epam.training.weapons.model.MachineGun;

import static com.epam.training.weapons.model.Blade.HandCount.ONE_HAND;

public class DivisionCreator {

    public Division create(){
        Division division = new Division();
        for (int i = 0; i < 100; i++) {
            Gun gun = new Gun(1,7.62,"basic Gun",400);
            Blade blade = new Blade("basic Knife",200,15, ONE_HAND);
            division.add(gun);
            division.add(blade);

        }
        for (int i = 0; i < 5 ; i++) {
            MachineGun machineGun = new MachineGun(1000,7.62,3000,"basic Machine Gun",600);
            division.add(machineGun);
        }
        return division;


    }
}
