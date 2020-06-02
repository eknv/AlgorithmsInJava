package com.eknv.algorithms.divide_conquer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MaxSubarraySumTests {

    @Test
    public void test1() {

        assertEquals(21, MaxSubarraySum.calculate(new int[]{2, 3, 4, 5, 7}));
        assertEquals(6, MaxSubarraySum.calculate(new int[]{-3, 1, -8, 4, -1, 2, 1, -5, 5}));

    }


}



