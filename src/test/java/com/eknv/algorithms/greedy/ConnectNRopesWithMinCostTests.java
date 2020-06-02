package com.eknv.algorithms.greedy;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectNRopesWithMinCostTests {

    @Test
    public void test() {
        assertEquals(29, ConnectNRopesWithMinCost.calculate(new Integer[]{4, 3, 2, 6}));
    }

}