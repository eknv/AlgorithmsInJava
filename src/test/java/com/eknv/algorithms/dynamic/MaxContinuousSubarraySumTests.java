package com.eknv.algorithms.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MaxContinuousSubarraySumTests {


    @Test
    public void test1() {

        assertEquals(21, MaxContinuousSubarraySum.calculate(new int[]{2, 3, 4, 5, 7}));
        assertEquals(6, MaxContinuousSubarraySum.calculate(new int[]{-3, 1, -8, 4, -1, 2, 1, -5, 5}));
        assertEquals(2, MaxContinuousSubarraySum.calculate(new int[]{2, -3, -2, 1}));
    }

    @Test
    public void test2() {

        assertEquals(21, MaxContinuousSubarraySum2.calculate(new int[]{2, 3, 4, 5, 7}));
        assertEquals(6, MaxContinuousSubarraySum2.calculate(new int[]{-3, 1, -8, 4, -1, 2, 1, -5, 5}));
        assertEquals(2, MaxContinuousSubarraySum2.calculate(new int[]{2, -3, -2, 1}));

    }

}