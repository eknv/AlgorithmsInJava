package com.eknv.algorithms.greedy;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectNPipesWithMinCostTests {

    @Test
    public void test() {
        assertEquals(29, ConnectNPipesWithMinCost.calculate(new int[]{4, 3, 2, 6}));
    }

}