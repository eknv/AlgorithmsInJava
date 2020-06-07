package com.eknv.algorithms.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MinimalLengthSubarrayTests {


    @Test
    public void test() {

        assertEquals(2, MinimalLengthSubarray.calculate(new int[]{2, 3, 1, 2, 4, 3}, 7));

        assertEquals(3, MinimalLengthSubarray.calculate(new int[]{2, 3, 1, 2, 3, 3}, 7));

        assertEquals(1, MinimalLengthSubarray.calculate(new int[]{2, 3, 1, 2, 3, 8}, 7));

        assertEquals(2, MinimalLengthSubarray.calculate(new int[]{6, 3, 1, 2, 3}, 7));

        assertEquals(0, MinimalLengthSubarray.calculate(new int[]{1, 1, 1, 1, 1, 1}, 7));

        assertEquals(0, MinimalLengthSubarray.calculate(new int[]{}, 7));

        assertEquals(7, MinimalLengthSubarray.calculate(new int[]{1, 1, 1, 1, 1, 1, 1}, 7));

    }

}