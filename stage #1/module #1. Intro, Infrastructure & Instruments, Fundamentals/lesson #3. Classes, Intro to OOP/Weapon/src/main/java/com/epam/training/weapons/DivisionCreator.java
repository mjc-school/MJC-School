package com.epam.training.weapons;

import com.epam.training.weapons.model.Blade;
import com.epam.training.weapons.model.Division;
import com.epam.training.weapons.model.Gun;
import com.epam.training.weapons.model.MachineGun;

import static com.epam.training.weapons.model.Blade.HandCount.ONE_HAND;

public class DivisionCreator {

    private int bladeAmount = 100;
    private int machineGunAmount = 5;
    private int gunCapacity = 1;
    private double gunCalibre = 7.62;
    private int gunWeight = 400;
    private int bladeWeight = 200;
    private int bladeLength = 15;
    private int machineGunCapacity = 1000;
    private double machineGunCalibre = 7.62;
    private int machineGunWeight = 3000;
    private int machineGunRapidity = 600;


    public Division create(){
        Division division = new Division();
        for (int i = 0; i < bladeAmount; i++) {
            Gun gun = new Gun(gunCapacity,gunCalibre,"basic Gun",gunWeight);
            Blade blade = new Blade("basic Knife",bladeWeight,bladeLength, ONE_HAND);
            division.add(gun);
            division.add(blade);

        }
        for (int i = 0; i < machineGunAmount; i++) {
            MachineGun machineGun = new MachineGun(machineGunCapacity, machineGunCalibre, machineGunWeight,"basic Machine Gun",machineGunRapidity);
            division.add(machineGun);
        }
        return division;


    }
}
