package com.eknv.algorithms.others;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UniquePointsInCycleTests {


    @Test
    public void test1() {

        assertEquals(3, UniquePointsInCircle.calculate("ABDCA", new int[]{2, -1, -4, -3, 3}, new int[]{2, -2, 4, 1, -3}));

        assertEquals(1, UniquePointsInCircle.calculate("ABB", new int[]{1, -2, -2}, new int[]{1, -2, 2}));

        assertEquals(3, UniquePointsInCircle.calculate("ABC", new int[]{1, -2, -2}, new int[]{1, -2, 2}));

    }


}