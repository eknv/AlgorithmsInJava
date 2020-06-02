package com.eknv.algorithms.divide_conquer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CollectCoinsInMinimumStepsTests {

    @Test
    public void test1() {

        assertEquals(4, CollectCoinsInMinimumSteps.calculate(new int[]{2, 1, 2, 5, 1}));
    }

}



