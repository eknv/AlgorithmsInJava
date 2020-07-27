package com.eknv.algorithms.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmallestNumberNotSumOfSubsetTests {


    @Test
    public void test1() {

        assertEquals(7, SmallestNumberNotSumOfSubset.calculate(new int[]{1, 2, 3, 8, 9, 10}));

        assertEquals(1, SmallestNumberNotSumOfSubset.calculate(new int[]{9, 10}));

        assertEquals(2, SmallestNumberNotSumOfSubset.calculate(new int[]{1, 9, 10}));

        assertEquals(39, SmallestNumberNotSumOfSubset.calculate(new int[]{1, 2, 3, 4, 5, 6, 7, 10}));

    }

    @Test
    public void oneElementLists() {

        assertEquals(2, SmallestNumberNotSumOfSubset.calculate(new int[]{1}));
        assertEquals(1, SmallestNumberNotSumOfSubset.calculate(new int[]{2}));
        assertEquals(1, SmallestNumberNotSumOfSubset.calculate(new int[]{3}));

    }

    @Test
    public void emptyList() {

        assertThrows(Exception.class, () -> SmallestNumberNotSumOfSubset.calculate(new int[]{}));

    }

    @Test
    public void nullArray() {

        assertThrows(Exception.class, () -> SmallestNumberNotSumOfSubset.calculate(null));

    }

    @Test
    public void arrayNotSorted() {

        assertThrows(Exception.class, () -> SmallestNumberNotSumOfSubset.calculate(new int[]{2, 1, 10}));

    }


}
