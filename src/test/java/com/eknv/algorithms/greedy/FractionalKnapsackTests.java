package com.eknv.algorithms.greedy;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionalKnapsackTests {

    @Test
    public void test() {
        double[] wt = {10, 40, 20, 30};
        double[] val = {60, 40, 100, 120};
        int capacity = 50;
        assertEquals(240.0, FractionalKnapsack.calculate(wt, val, capacity));
    }

}