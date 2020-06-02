package com.eknv.algorithms.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SplitArrayTests {


    @Test
    public void test1() {

        assertEquals(3, SplitArray.calculate(new int[]{5, 5, 2, 3, 5, 1, 6}, 5));
        assertEquals(5, SplitArray.calculate(new int[]{5, 2, 2, 3, 4, 3, 5, 6}, 5));
        assertEquals(8, SplitArray.calculate(new int[]{2, 2, 2, 3, 5, 4, 8, 5, 3, 5, 1}, 5));
    }


}
