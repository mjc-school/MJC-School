package com.epam.training.weapons;

import com.epam.training.weapons.model.Division;
import org.junit.Test;
import static org.junit.Assert.*;

public class DivisionCreateTest {

    @Test
    public void createTest(){
        DivisionCreator creator = new DivisionCreator();
        Division testDivision = creator.create();
        assertNotNull(testDivision);

        assertEquals("Standart Division",testDivision.getName());
        assertEquals(205,testDivision.getWeapons().size());
    }
}
