package com.eknv.algorithms.dynamic;


import org.junit.jupiter.api.Test;

import static com.eknv.algorithms.dynamic.CakeThief.maxDuffelBagValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CakeThiefTests {


    @Test
    public void oneCakeTest() {
        final CakeThief.CakeType[] cakeTypes = {new CakeThief.CakeType(2, 1)};
        final int weightCapacity = 9;
        final long expected = 4;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void twoCakesTest() {
        final CakeThief.CakeType[] cakeTypes = {new CakeThief.CakeType(4, 4), new CakeThief.CakeType(5, 5)};
        final int weightCapacity = 9;
        final long expected = 9;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void onlyTakeLessValuableCakeTest() {
        final CakeThief.CakeType[] cakeTypes = {new CakeThief.CakeType(4, 4), new CakeThief.CakeType(5, 5)};
        final int weightCapacity = 12;
        final long expected = 12;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void lotsOfCakesTest() {
        final CakeThief.CakeType[] cakeTypes = {
                new CakeThief.CakeType(2, 3), new CakeThief.CakeType(3, 6), new CakeThief.CakeType(5, 1),
                new CakeThief.CakeType(6, 1), new CakeThief.CakeType(7, 1), new CakeThief.CakeType(8, 1)
        };
        final int weightCapacity = 7;
        final long expected = 12;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }


    @Test
    public void valueToWeightRatioIsNotOptimalTest() {
        final CakeThief.CakeType[] cakeTypes = {new CakeThief.CakeType(51, 52), new CakeThief.CakeType(50, 50)};
        final int weightCapacity = 100;
        final long expected = 100;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void zeroCapacityTest() {
        final CakeThief.CakeType[] cakeTypes = {new CakeThief.CakeType(1, 2)};
        final int weightCapacity = 0;
        final long expected = 0;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void cakeWithZeroValueAndWeightTest() {
        final CakeThief.CakeType[] cakeTypes = {new CakeThief.CakeType(0, 0), new CakeThief.CakeType(2, 1)};
        final int weightCapacity = 7;
        final long expected = 3;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }


    @Test
    public void cakeWithNonZeroValueAndZeroWeightTest() {
        final CakeThief.CakeType[] cakeTypes = {new CakeThief.CakeType(0, 5)};
        final int weightCapacity = 5;
        assertThrows(Exception.class, () -> maxDuffelBagValue(cakeTypes, weightCapacity));
    }


}