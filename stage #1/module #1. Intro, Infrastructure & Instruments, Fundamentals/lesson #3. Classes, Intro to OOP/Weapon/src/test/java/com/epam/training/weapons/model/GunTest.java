package com.epam.training.weapons.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class GunTest {

    @Test
    public void testGetCapacity(){
        Gun testGun = new Gun(3,2.5,"testGun",400);
        int testGunCapacity = testGun.getCapacity();
        assertEquals(3,testGunCapacity);
    }

    @Test
    public void testSetCapacity(){
        Gun testGun = new Gun(3,2.5,"testGun",400);
        testGun.setCapacity(1);
        int testGunCapacity = testGun.getCapacity();
        assertEquals(1,testGunCapacity);

        testGun.setName("testGunNewName");
        assertEquals("testGunNewName",testGun.getName());

        testGun.setWeight(900);
        assertEquals(900,testGun.getWeight());
    }

    @Test
    public void testGetCalibre(){
        Gun testGun = new Gun(3,2.5,"testGun",400);
        double testGunCalibre = testGun.getCalibre();
        assertTrue(2.5 == testGunCalibre);

        assertEquals("testGun",testGun.getName());
        assertEquals(400,testGun.getWeight());


    }

    @Test
    public void testSetCalibre(){
        Gun testGun = new Gun(3,2.5,"testGun",400);
        testGun.setCalibre(1.4);
        double testGunCalibre = testGun.getCalibre();
        assertTrue(1.4 == testGunCalibre);
    }

    @Test
    public void testEqualsHashCode(){
        Gun testGun1 = new Gun(3,2.5,"testGun",400);
        Gun testGun2 = new Gun(3,2.5,"testGun",400);
        Gun testGun3 = new Gun(3,3.5,"testGun",400);

        assertTrue(testGun1.equals(testGun2));
        assertFalse(testGun1.equals(testGun3));
        assertTrue(testGun1.hashCode() == testGun2.hashCode());


    }
}
