package com.epam.training.weapons;

import com.epam.training.weapons.model.Division;
import com.epam.training.weapons.view.DivisionPrinter;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void mainTest(){

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String expectedOutPut = "Division name: Catana Division\n" +
                "Weapon weight: 76500.0\n" +
                "Weapon quantity: 206" + System.getProperty("line.separator");

        String[] args = {};
        Main.main(args);

        assertEquals(expectedOutPut, out.toString());
    }
}
