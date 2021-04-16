package com.epam.training.weapons.view;

import com.epam.training.weapons.model.Division;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class DivisionPrinterTest {

    @Test
    public void printTest(){

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String expectedOutPut = "Division name: Standart Division\n" +
                "Weapon weight: 0.0\n" +
                "Weapon quantity: 0" + System.getProperty("line.separator");
        DivisionPrinter testPrinter = new DivisionPrinter();
        Division division = new Division();
        testPrinter.print(division);

        assertEquals(expectedOutPut, out.toString());
    }

}
