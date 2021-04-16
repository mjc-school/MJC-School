package com.epam.training.weapons.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class MachineGunTest {
    @Test
    public void getRapidityTest(){

        MachineGun testMachineGun = new MachineGun(2,4.5,3000,
                "testMachineGun",5);
        int rapidity = testMachineGun.getRapidity();
        assertEquals(5,rapidity);
    }
    @Test
    public void testSetRapidity(){
        MachineGun testMachineGun = new MachineGun(2,4.5,3000,
                "testMachineGun",5);
        testMachineGun.setRapidity(8);
        int testRapidity = testMachineGun.getRapidity();

        assertEquals(8,testRapidity);
    }
    @Test
    public void testEqualsHashCode(){
        MachineGun testMachineGun1 = new MachineGun(2,4.5,3000,
                "testMachineGun",5);
        MachineGun testMachineGun2 = new MachineGun(2,4.5,3000,
                "testMachineGun",5);
        assertTrue(testMachineGun1.equals(testMachineGun2));
        assertTrue(testMachineGun1.hashCode() == testMachineGun2.hashCode());

        MachineGun testMachineGun3 = new MachineGun(2,4.5,3000,
                "testMachineGun",9);
        assertFalse(testMachineGun1.equals(testMachineGun3));

    }
}
