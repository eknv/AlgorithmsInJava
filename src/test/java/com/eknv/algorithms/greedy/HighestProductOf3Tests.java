package com.eknv.algorithms.greedy;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighestProductOf3Tests {

    @Test
    public void test1() {
        assertEquals(24, HighestProductOf3.calculate(new int[]{1, 2, 3, 4}));
        assertEquals(-6, HighestProductOf3.calculate(new int[]{-5, -1, -3, -2}));
        assertEquals(30, HighestProductOf3.calculate(new int[]{-5, -1, 3, -2}));
        assertEquals(336, HighestProductOf3.calculate(new int[]{6, 1, 3, 5, 7, 8, 2}));
    }

}