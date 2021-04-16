package com.epam.training.weapons.model;

import org.junit.Test;

import static com.epam.training.weapons.model.Blade.HandCount.TWO_HAND;
import static org.junit.Assert.*;

import static com.epam.training.weapons.model.Blade.HandCount.ONE_HAND;

public class BladeTest {

    @Test
    public void testGetLength(){
        Blade testBlade = new Blade("testBlade",300,400,ONE_HAND);
        int testBladeLength = testBlade.getLength();
        assertEquals(400,testBladeLength);
    }

    @Test
    public void testSetLength(){
        Blade testBlade = new Blade("testBlade",300,400,ONE_HAND);
        testBlade.setLength(700);
        int testBladeLength = testBlade.getLength();
        assertEquals(700,testBladeLength);

    }

    @Test
    public  void testGetHandCount(){
        Blade testBlade = new Blade("testBlade",300,400,ONE_HAND);
        Enum testBladeHandCount = testBlade.getHandCount();
        assertEquals(ONE_HAND,testBladeHandCount);
    }

    @Test
    public  void testSetHandCount(){
        Blade testBlade = new Blade("testBlade",300,400,ONE_HAND);
        testBlade.setHandCount(TWO_HAND);
        Enum testBladeHandCount = testBlade.getHandCount();
        assertEquals(TWO_HAND,testBladeHandCount);
    }

    @Test
    public void testEqualsHashCode(){
        Blade testBlade1 = new Blade("testBlade",300,400,ONE_HAND);
        Blade testBlade2 = new Blade("testBlade",300,400,ONE_HAND);
        Blade testBlade3 = new Blade("testBlade",600,400,ONE_HAND);
        assertTrue(testBlade1.equals(testBlade2));
        assertFalse(testBlade1.equals(testBlade3));
        assertTrue(testBlade1.hashCode() == testBlade2.hashCode());
    }

}
