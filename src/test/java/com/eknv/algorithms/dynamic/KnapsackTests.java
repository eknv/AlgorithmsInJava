package com.eknv.algorithms.dynamic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnapsackTests {





    @Test
    void test() {

        int[] val = new int[]{60, 59, 70};
        int[] wt = new int[]{20, 30, 40};
        int W = 70;

        assertEquals(130, Knapsack.calculate(W, wt, val));
    }

    @Test
    void test2() {

        int val[] = new int[]{60, 59, 70};
        int wt[] = new int[]{20, 30, 40};
        int W = 70;

        assertEquals(130, Knapsack2.calculate(W, wt, val));
    }

    @Test
    void test3() {
        int val[] = new int[]{60, 59, 70};
        int wt[] = new int[]{20, 30, 40};
        int W = 70;

        assertEquals(130, Knapsack3.calculate(W, wt, val));
    }


}
