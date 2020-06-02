package com.eknv.algorithms.divide_conquer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MissingNumberInSortedArrayTests {

    @Test
    public void test1() {

        assertEquals(2, MissingNumberInSortedArray.calculate(new int[]{1, 3, 4}));

        assertEquals(7, MissingNumberInSortedArray.calculate(new int[]{1, 2, 3, 4, 5, 6, 8}));

    }

}



