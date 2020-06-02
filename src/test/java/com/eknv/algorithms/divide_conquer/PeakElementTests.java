package com.eknv.algorithms.divide_conquer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PeakElementTests {

    @Test
    public void testIterative() {
        assertEquals(30, PeakElement.calculate(new int[]{1, 30, 1}));
        assertEquals(3, PeakElement.calculate(new int[]{1, 3, 3, 3, 1, 1, 20}));
        assertEquals(3, PeakElement.calculate(new int[]{1, 2, 3}));
        assertEquals(3, PeakElement.calculate(new int[]{3, 2, 1}));
    }

    @Test
    public void testRecursively() {
        assertEquals(30, PeakElement.calculateRecursively(new int[]{1, 30, 1}));
        assertEquals(3, PeakElement.calculateRecursively(new int[]{1, 3, 3, 3, 1, 1, 20}));
        assertEquals(3, PeakElement.calculateRecursively(new int[]{1, 2, 3}));
        assertEquals(3, PeakElement.calculateRecursively(new int[]{3, 2, 1}));
    }

}
