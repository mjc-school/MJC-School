package com.epam.training.weapons;

import com.epam.training.weapons.logic.DivisionLogic;
import com.epam.training.weapons.model.AbstractWeapon;
import com.epam.training.weapons.model.Blade;
import com.epam.training.weapons.model.Division;
import com.epam.training.weapons.view.DivisionPrinter;

import static com.epam.training.weapons.model.Blade.HandCount.TWO_HAND;

public class Main {

  public static void main (String[] args){

      DivisionCreator creator = new DivisionCreator();

      Division division = creator.create();
      AbstractWeapon blade = new Blade("Catana",1500,1000, TWO_HAND);
      division.add(blade);
      division.setName("Catana Division");


      double weight = DivisionLogic.calculateTotalWeight(division);

      DivisionPrinter printer = new DivisionPrinter();
      printer.print(division);


  }


}
