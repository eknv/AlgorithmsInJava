package com.eknv.algorithms.divide_conquer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EuclideanExtendedTests {

    @Test
    public void test1() {

        assertEquals("GCD: 5, X: 1, Y: -2", EuclideanExtended.calculate(35, 15).toString());
        assertEquals("GCD: 5, X: 1, Y: -3", EuclideanExtended.calculate(35, 10).toString());
        assertEquals("GCD: 1, X: 1, Y: -15", EuclideanExtended.calculate(31, 2).toString());
    }


}



